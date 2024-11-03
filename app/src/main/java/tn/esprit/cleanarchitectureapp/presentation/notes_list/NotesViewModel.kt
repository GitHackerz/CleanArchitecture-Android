package tn.esprit.cleanarchitectureapp.presentation.notes_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import tn.esprit.cleanarchitectureapp.domain.model.Note
import tn.esprit.cleanarchitectureapp.domain.repository.NoteRepository
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val noteRepository: NoteRepository
) : ViewModel() {


    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val notes = _notes.asStateFlow()

    init {
        loadNotes()
    }


    fun loadNotes() {
        viewModelScope.launch {
            _notes.value = noteRepository.getNotes()
        }
    }

}