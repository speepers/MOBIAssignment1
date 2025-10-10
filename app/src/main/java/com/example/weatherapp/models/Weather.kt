package com.example.weatherapp.models

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
)

data class Current(
    val date: String,
    val highTemp: String,
    val lowTemp: String,
    val condition: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val precipitationProbability: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String,
    val iconRes: Int
)

data class Forecast(
    val date: String,
    val highTemp: String,
    val lowTemp: String,
    val condition: String,
    val precipitationType: String,
    val precipitationAmount: String,
    val precipitationProbability: String,
    val windDirection: String,
    val windSpeed: String,
    val humidity: String,
    val iconRes: Int
)