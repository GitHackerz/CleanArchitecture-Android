package tn.esprit.cleanarchitectureapp.presentation.notes_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import tn.esprit.cleanarchitectureapp.presentation.notes_list.components.NoteItem

@Composable
fun NotesListScreen() {
    val notesViewModel = hiltViewModel<NotesViewModel>()
    val notes = notesViewModel.notes.collectAsState()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            notes.value.forEach { note ->
                NoteItem(note)
            }
        }
    }
}

@Preview
@Composable
fun NotesListScreenPreview() {
    NotesListScreen()
}