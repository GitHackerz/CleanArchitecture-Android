package tn.esprit.cleanarchitectureapp.navigation

sealed class Screen(val route: String) {
    object NotesListScreen : Screen("notes_list")
    object NoteDetailsScreen : Screen("note_details")
}