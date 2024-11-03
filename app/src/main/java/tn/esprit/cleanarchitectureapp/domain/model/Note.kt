package tn.esprit.cleanarchitectureapp.domain.model

data class Note(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long
)
