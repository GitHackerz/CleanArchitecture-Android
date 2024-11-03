package tn.esprit.cleanarchitectureapp.presentation.notes

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
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {

    private val _notesState = MutableStateFlow(NotesState())
    val notesState = _notesState.asStateFlow()

    init {
        loadNotes()
    }


    fun loadNotes() {
        viewModelScope.launch {
            noteRepository.getNotes().let { notes ->
                _notesState.update {
                    it.copy(notes = notes)
                }
            }
        }
    }

}