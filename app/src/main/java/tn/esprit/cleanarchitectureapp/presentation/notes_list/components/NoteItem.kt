package tn.esprit.cleanarchitectureapp.presentation.notes_list.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import tn.esprit.cleanarchitectureapp.domain.model.Note

@Composable
fun NoteItem(note: Note) {
    Text(text = note.title)
}
