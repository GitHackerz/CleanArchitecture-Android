package tn.esprit.cleanarchitectureapp.data.remote.dto

import tn.esprit.cleanarchitectureapp.domain.model.Note

data class NoteDto(
    val id: Int,
    val title: String,
    val content: String,
    val timestamp: Long
) {
    fun toNote() = Note(
        id = id,
        title = title,
        content = content,
        timestamp = timestamp
    )

    companion object {
        fun fromNote(note: Note) = NoteDto(
            id = note.id,
            title = note.title,
            content = note.content,
            timestamp = note.timestamp
        )
    }
}
