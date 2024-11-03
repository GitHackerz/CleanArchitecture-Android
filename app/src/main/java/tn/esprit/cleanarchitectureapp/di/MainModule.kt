package tn.esprit.cleanarchitectureapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import tn.esprit.cleanarchitectureapp.data.remote.NoteApiService
import tn.esprit.cleanarchitectureapp.data.repository.NoteRepositoryImpl
import tn.esprit.cleanarchitectureapp.domain.repository.NoteRepository
import tn.esprit.cleanarchitectureapp.utils.DateTypeAdapter
import java.util.Date
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {


    private val interceptor: HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    private val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Date::class.java, DateTypeAdapter())
            .create()
    }

    @Provides
    @Singleton
    fun providesNotesApi(gson: Gson): NoteApiService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(NoteApiService.BASE_URL)
            .client(client)
            .build()
            .create(NoteApiService::class.java)
    }

    @Provides
    @Singleton
    fun providesNoteRepository(noteApiService: NoteApiService): NoteRepository {
        return NoteRepositoryImpl(noteApiService)
    }

}
