package tn.esprit.cleanarchitectureapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tn.esprit.cleanarchitectureapp.presentation.note_details.NoteDetailsScreen
import tn.esprit.cleanarchitectureapp.presentation.notes.NotesListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.NotesListScreen.route) {
        composable(route = Screen.NotesListScreen.route) {
            NotesListScreen(navController)
        }
        composable(route = Screen.NoteDetailsScreen.route + "/{noteId}") { backStackEntry ->
            // OPTIONAL: Get the noteId from the arguments and pass it through params
            // You can access the arguments in ViewModel Directly using savedStateHandle

            // val noteId = backStackEntry.arguments?.getString("noteId")?.toInt() ?: 0
            NoteDetailsScreen()
        }
    }
}