package ru.skillbranch.gameofthrones.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.skillbranch.gameofthrones.dao.HouseDao
import ru.skillbranch.gameofthrones.data.local.entities.House

@Database(
        entities = [House::class],
        version = 1
)
@TypeConverters(Converters::class)
abstract class GameOfThronesDatabase : RoomDatabase(){

    abstract fun getHousesDao(): HouseDao

    companion object{
        @Volatile
        private var instance: GameOfThronesDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}
        }

        private fun createDatabase(context: Context) =
                Room.databaseBuilder(
                        context.applicationContext,
                        GameOfThronesDatabase::class.java,
                        "got_db.db"
                ).build()
    }
}