package ru.skillbranch.gameofthrones.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.skillbranch.gameofthrones.data.local.entities.House

interface GameOfThronesApi {

    @GET("houses/")

    /*suspend */fun getHouse(
       @Query("name") houseName: String
    ) : Call<List<House>>
}