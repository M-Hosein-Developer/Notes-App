package com.example.Room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.Room.Converter.NoteTypeConverter
import com.example.Room.Entities.NoteEntity

@TypeConverters(NoteTypeConverter :: class)
@Database(entities = [NoteEntity :: class] , version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun roomDao() : RoomDao
}