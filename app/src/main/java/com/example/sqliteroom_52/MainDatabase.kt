package com.example.sqliteroom_52

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database()
abstract class MainDatabase:RoomDatabase() {

    companion object{
        fun getDatabase(context: Context): MainDatabase{
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "test.database"
            ).build()
        }
    }
}