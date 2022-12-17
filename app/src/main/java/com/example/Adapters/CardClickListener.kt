package com.example.Adapters

import android.view.View
import androidx.constraintlayout.utils.widget.ImageFilterButton
import com.example.Room.Entities.NoteEntity

interface CardClickListener {

    fun onItemClickListener(noteEntity: NoteEntity)

    fun onMenuItemClickListener(imageFilterButton: View , noteEntity: NoteEntity)
}