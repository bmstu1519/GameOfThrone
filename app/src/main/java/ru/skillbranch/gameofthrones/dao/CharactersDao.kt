package ru.skillbranch.gameofthrones.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import ru.skillbranch.gameofthrones.data.local.entities.Character
import ru.skillbranch.gameofthrones.data.local.entities.CharacterItem

@Dao
interface CharactersDao : BaseDao<Character> {

    @Query(
            """
                SELECT * FROM CharacterItem
                WHERE house = :title
            """
    )
    fun findCharacters(title: String) : LiveData<List<CharacterItem>>
}