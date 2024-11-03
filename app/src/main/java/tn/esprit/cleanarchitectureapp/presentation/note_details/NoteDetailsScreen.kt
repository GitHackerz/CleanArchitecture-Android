package tn.esprit.cleanarchitectureapp.presentation.note_details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun NoteDetailsScreen() {
    val noteDetailsViewModel = hiltViewModel<NoteDetailsViewModel>()
    val noteState by noteDetailsViewModel.noteDetailsState.collectAsState()

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(text = noteState.note?.title ?: "")
            Text(text = noteState.note?.content ?: "")
        }
    }
}