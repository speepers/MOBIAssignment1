package com.example.weatherapp.services

import retrofit2.http.GET
import com.example.weatherapp.models.Weather
import retrofit2.http.Path
import retrofit2.http.Query

interface WeatherService {
}

//interface PokemonService {
//
//    @GET("pokemon/{name}")
//    suspend fun getPokemon(
//        @Path("name") name: String
//    ): Pokemon
//
//    @GET("pokemon")
//    suspend fun getAllPokemon(
//        @Query("limit") limit: Int,
//        @Query("offset") offset: Int
//    ): List<Pokemon>
//}