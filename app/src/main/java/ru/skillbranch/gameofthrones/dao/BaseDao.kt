package ru.skillbranch.gameofthrones.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T : Any> {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(obj: List<T>) : List<Long>
    @Update
    fun update(obf: List<T>)
}