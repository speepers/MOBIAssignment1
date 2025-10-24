package com.example.weatherapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.models.Weather
import com.example.weatherapp.network.WeatherService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val _weather = MutableStateFlow<Weather?>(null)
    val weather = _weather.asStateFlow()
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val weatherService: WeatherService = retrofit.create(WeatherService::class.java)
    private val apiKey = "da4116e66fb849b29f9123157251710"

    init {
        fetchWeather("Halifax")
    }

    fun fetchWeather(location: String, days: Int = 3) {
        viewModelScope.launch {
            val weatherFromAPI = weatherService.getWeather(
                apiKey = apiKey,
                location = location,
                days = days,
                aqi = "no",
                alerts = "no"
            )
            _weather.value = weatherFromAPI
        }
    }
}