package tn.esprit.cleanarchitectureapp.data.repository

import tn.esprit.cleanarchitectureapp.data.remote.NoteApiService
import tn.esprit.cleanarchitectureapp.data.remote.dto.NoteDto
import tn.esprit.cleanarchitectureapp.domain.model.Note
import tn.esprit.cleanarchitectureapp.domain.repository.NoteRepository

class NoteRepositoryImpl(private val noteApiService: NoteApiService): NoteRepository {
    override suspend fun getNotes() = noteApiService.getNotes().map { it.toNote() }

    override suspend fun getNoteById(id: Int) = noteApiService.getNoteById(id).toNote()

    override suspend fun addNote(note: Note) = noteApiService.addNote(NoteDto.fromNote(note))

    override suspend fun updateNote(note: Note) = noteApiService.updateNote(NoteDto.fromNote(note))

    override suspend fun deleteNoteById(id: Int) = noteApiService.deleteNoteById(id)
}