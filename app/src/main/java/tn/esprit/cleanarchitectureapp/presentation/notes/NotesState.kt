package tn.esprit.cleanarchitectureapp.presentation.notes

import tn.esprit.cleanarchitectureapp.domain.model.Note

data class NotesState(
    val notes: List<Note> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
