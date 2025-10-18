package com.example.weatherapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Current
import com.example.weatherapp.models.Forecast
import com.example.weatherapp.models.Weather
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()

    // you need to create a variable to store the pokemon data into
    // private var pokemon by mutableStateOf<Pokemon?>(null)

    // retrofit instance
    // val retrofit: Retrofit = Retrofit.Builder()
    //    .baseUrl("https://pokeapi.co/api/v2/")
    //    .addConverterFactory(GsonConverterFactory.create())
    //    .build()

    // initalize the interface service
    // val pokemonService: PokemonService = retrofit.create(PokemonService::class.java)


    init {

        // viewModelScope.launch {
        //     fetch the pokemon from the api
        //     val pokemonFromAPI = pokemonService.getPokemon()
        //     _pokemon.value = pokemonFromAPI
        // }

        val weatherData = Weather(
            current = Current(
                date = "Today - Sept 26",
                highTemp = "25°C",
                lowTemp = "18°C",
                condition = "Cloudy",
                precipitationType = "Light Rain",
                precipitationAmount = "2.5mm",
                precipitationProbability = "60%",
                windDirection = "Northwest",
                windSpeed = "15 km/h",
                humidity = "78%",
                iconRes = R.drawable.cloudy
            ),
            forecast = listOf(
                Forecast(
                    date = "Today - Sept 26",
                    highTemp = "25°C",
                    lowTemp = "18°C",
                    condition = "Cloudy",
                    precipitationType = "Light Rain",
                    precipitationAmount = "2.5mm",
                    precipitationProbability = "60%",
                    windDirection = "Northwest",
                    windSpeed = "15 km/h",
                    humidity = "78%",
                    iconRes = R.drawable.cloudy
                ),
                Forecast(
                    date = "Tomorrow - Sept 27",
                    highTemp = "28°C",
                    lowTemp = "20°C",
                    condition = "Sunny",
                    precipitationType = "No Rain",
                    precipitationAmount = "0mm",
                    precipitationProbability = "5%",
                    windDirection = "West",
                    windSpeed = "12 km/h",
                    humidity = "65%",
                    iconRes = R.drawable.cloudy
                ),
                Forecast(
                    date = "Sept 28",
                    highTemp = "24°C",
                    lowTemp = "16°C",
                    condition = "Partly Cloudy",
                    precipitationType = "Showers",
                    precipitationAmount = "5.2mm",
                    precipitationProbability = "40%",
                    windDirection = "East",
                    windSpeed = "18 km/h",
                    humidity = "82%",
                    iconRes = R.drawable.cloudy
                )
            )
        )
        _weather.value = weatherData
    }
}