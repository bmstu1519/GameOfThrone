package ru.skillbranch.gameofthrones.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem
import ru.skillbranch.gameofthrones.repositories.RootRepository

class HouseViewModel(private val houseName : String) : ViewModel(){

    private val repository = RootRepository
    private val queryStr = mutableLiveData

    fun getCharacters(): LiveData<List<CharacterItem>>{
        val characters = repository.findCharacters(houseName)
    }
}