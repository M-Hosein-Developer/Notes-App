package com.example.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.Models.NotesModel
import com.example.Repository.AppRepository
import com.example.Room.Entities.NoteEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: AppRepository) : ViewModel() {

    init {
        getAllDataFromDb()
    }

    private var data : MutableLiveData<List<NoteEntity>> = MutableLiveData()
    var liveData : LiveData<List<NoteEntity>> = data


    fun insetNoteToDatabase(notesModel: NotesModel) {

        viewModelScope.launch (Dispatchers.IO){
            repository.insertNote(notesModel)
        }

    }

    fun UpdateNoteDatabaset (noteEntity: NoteEntity) {

        viewModelScope.launch (Dispatchers.IO){
            repository.UpdateNote(noteEntity)
        }

    }

    fun deleteNote (noteEntity: NoteEntity) {

        viewModelScope.launch (Dispatchers.IO){
            repository.deleteNote(noteEntity)
        }

    }

    fun getAllDataFromDb(){
        viewModelScope.launch (Dispatchers.IO) {
            repository.getAllData().collect{
                data.postValue(it)
            }
        }
    }

}