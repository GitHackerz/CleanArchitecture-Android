package tn.esprit.cleanarchitectureapp.presentation.note_details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tn.esprit.cleanarchitectureapp.domain.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NoteDetailsViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _noteDetailsState = MutableStateFlow(NoteDetailsState())
    val noteDetailsState = _noteDetailsState.asStateFlow()

    init {
        val noteId = savedStateHandle.get<String>("noteId")
        loadNote(noteId!!.toInt())
    }

    fun loadNote(id: Int) {
        viewModelScope.launch {
            val note = noteRepository.getNoteById(id)
            _noteDetailsState.update { it.copy(note = note) }
        }
    }
}