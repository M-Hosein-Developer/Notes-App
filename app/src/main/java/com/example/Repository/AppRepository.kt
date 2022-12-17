package com.example.Repository

import com.example.Models.NotesModel
import com.example.Room.AppDatabase
import com.example.Room.Entities.NoteEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepository @Inject constructor(appDatabase: AppDatabase){

    private val roomDao = appDatabase.roomDao()

    fun insertNote(notesModel: NotesModel) {

        val noteEntity = NoteEntity(0 , notesModel)
        roomDao.insert(noteEntity)

    }

    fun deleteNote(noteEntity: NoteEntity) {
        
        roomDao.delete(noteEntity)

    }

    fun UpdateNote(noteEntity: NoteEntity) {

        roomDao.update(noteEntity)

    }

    fun getAllData() : Flow<List<NoteEntity>>{
        return roomDao.getAll()
    }

}