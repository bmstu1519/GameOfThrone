package ru.skillbranch.gameofthrones.dao

import androidx.room.*

@Dao
interface HouseDao {
    @Query(
            """
                SELECT count(*) FROM houses
            """
    )
    suspend fun recordsCount() : Int

}