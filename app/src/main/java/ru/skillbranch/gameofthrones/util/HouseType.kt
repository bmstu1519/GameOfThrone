package ru.skillbranch.gameofthrones.util

import androidx.annotation.DrawableRes
import ru.skillbranch.gameofthrones.R
import java.lang.IllegalStateException

enum class HouseType (
        val title : String,
        @DrawableRes
        val icon: Int
) {
    STARK("Stark", R.drawable.stark_icon),
    LANNISTER("Lannister", R.drawable.lanister_icon),
    TARGARYEN("Targaryen", R.drawable.targaryen_icon),
    BARATHEON("Baratheon", R.drawable.baratheon_icon),
    GREYJOY("Greyjoy", R.drawable.greyjoy_icon),
    MARTELL("Martell", R.drawable.martel_icon),
    TYRELL("Tyrell", R.drawable.tyrel_icon);

    companion object{
        fun fromString(title: String): HouseType{
            return when(title){
                "Stark" -> STARK
                "Lannister" -> LANNISTER
                "Targaryen" -> TARGARYEN
                "Baratheon" -> BARATHEON
                "Greyjoy" -> GREYJOY
                "Martell" -> MARTELL
                "Tyrell" -> TYRELL
                else -> throw IllegalStateException("unknown house $title")

            }
        }
    }


}