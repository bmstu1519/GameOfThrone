package ru.skillbranch.gameofthrones.data.local.entities

import androidx.room.Room

object  DbManager{
    val db = Room.databaseBuilder(
            App
    )
}