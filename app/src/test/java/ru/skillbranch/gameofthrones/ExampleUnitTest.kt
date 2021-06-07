package ru.skillbranch.gameofthrones

import androidx.core.text.isDigitsOnly
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun mapFun() {
        val regex = Regex("[^0-9]")
        val oldArray = listOf("https://www.anapioficeandfire.com/api/characters/2",
                "https://www.anapioficeandfire.com/api/characters/20",
                "https://www.anapioficeandfire.com/api/characters/97",
                "https://www.anapioficeandfire.com/api/characters/98",
                "https://www.anapioficeandfire.com/api/characters/136",
                "https://www.anapioficeandfire.com/api/characters/143",
                "https://www.anapioficeandfire.com/api/characters/148",
                "https://www.anapioficeandfire.com/api/characters/170",
                "https://www.anapioficeandfire.com/api/characters/181",
        )
        val newArray = oldArray.map { regex.replace(it,"") }

        val listToString = newArray.toString()

        println("string : $listToString")
        println("array : $newArray")
    }
}