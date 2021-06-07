package ru.skillbranch.gameofthrones.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.skillbranch.gameofthrones.util.HouseType


@Entity(tableName = "characters")
data class Character(
        @PrimaryKey
        val id: String,
        val houseName: String,
        val name: String,
        val gender: String,
        val culture: String,
        val born: String,
        val died: String,
        val titles: List<String> = listOf(),
        val aliases: List<String> = listOf(),
        val father: String, //rel
        val mother: String, //rel
        val spouse: String,
        @ColumnInfo(name = "house_id")
        val houseId: HouseType
)
@DatabaseView(
        """
            SELECT house_id as house, id, name, aliases, titles
            FROM characters
            ORDER BY name ASC
        """
)

data class CharacterItem(
    val id: String,
    val house: HouseType, //rel
    val name: String,
    val titles: List<String>,
    val aliases: List<String>
)

data class CharacterFull(
    val id: String,
    val name: String,
    val words: String,
    val born: String,
    val died: String,
    val titles: List<String>,
    val aliases: List<String>,
    val house: String, //rel
//    val father: RelativeCharter?,
//    val mother: RelativeCharter?
)

data class RelativeCharacter(
    val id: String,
    val name: String,
    val house:String //rel
)