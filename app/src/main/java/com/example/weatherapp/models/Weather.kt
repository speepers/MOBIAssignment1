package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val current: Current,
    val forecast: List<Forecast>
)

data class Current(
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("temp_c") val currentTemp: Double,
    @SerializedName("feelslike_c") val feelsLike: Double,
    @SerializedName("precip_mm") val precipAmt: Double,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("wind_kph") val windSpeed: Double,
    val condition: Condition,
    val humidity: Int,
    val iconRes: Int
)

data class Forecast(
    @SerializedName("last_updated") val lastUpdated: String,
    @SerializedName("temp_c") val currentTemp: Double,
    @SerializedName("feelslike_c") val feelsLike: Double,
    @SerializedName("precip_mm") val precipAmt: Double,
    @SerializedName("wind_dir") val windDirection: String,
    @SerializedName("wind_kph") val windSpeed: Double,
    val condition: Condition,
    val humidity: Int,
    val iconRes: Int
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)