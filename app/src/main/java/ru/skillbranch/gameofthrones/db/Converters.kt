package ru.skillbranch.gameofthrones.db

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromStringList(list: List<String>) : String = list.toString().removeSurrounding("[","]")

    @TypeConverter
    fun toStringList(string: String) : List<String> = string.split(',').toList()
}