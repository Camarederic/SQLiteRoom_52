package com.example.sqliteroom_52

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class MainDatabase : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        fun getDatabase(context: Context): MainDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MainDatabase::class.java,
                "test.database"
            ).build()
        }
    }
}