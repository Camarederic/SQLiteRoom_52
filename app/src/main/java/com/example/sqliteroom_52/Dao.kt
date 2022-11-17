package com.example.sqliteroom_52

import kotlinx.coroutines.flow.Flow
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    fun insertItem(item: Item)

    @Query("SELECT * FROM items")
    fun getAllItem(): Flow<List<Item>>
}