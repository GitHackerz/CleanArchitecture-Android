package tn.esprit.cleanarchitectureapp.data.remote

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import tn.esprit.cleanarchitectureapp.data.remote.dto.NoteDto

interface NoteApiService {

    companion object {
        const val BASE_URL = "http://192.168.1.20:3050/api/v1/"
    }

    @GET("notes")
    suspend fun getNotes(): List<NoteDto>

    @GET("notes/{id}")
    suspend fun getNoteById(@Path("id") id: Int): NoteDto

    @POST("notes")
    suspend fun addNote(note: NoteDto)

    @PATCH("notes/{id}")
    suspend fun updateNote(note: NoteDto)

    @DELETE("notes/{id}")
    suspend fun deleteNoteById(id: Int)


}