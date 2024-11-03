package tn.esprit.cleanarchitectureapp.presentation.notes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tn.esprit.cleanarchitectureapp.domain.model.Note
import tn.esprit.cleanarchitectureapp.navigation.Screen

@Composable
fun NotesListScreen(navController: NavController) {
    val notesViewModel = hiltViewModel<NotesViewModel>()
    val notesState by notesViewModel.notesState.collectAsState()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            notesState.notes.forEach { note ->
                NoteItem(note, navController)
            }
        }
    }
}

@Composable
fun NoteItem(note: Note, navController: NavController) {
    Text(text = note.title, modifier = Modifier.clickable {
        navController.navigate(Screen.NoteDetailsScreen.route + "/${note.id}")
    })
}
