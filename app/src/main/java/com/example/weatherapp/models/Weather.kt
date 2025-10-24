package com.example.weatherapp.models

import com.google.gson.annotations.SerializedName

data class Weather(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)

data class Location(
    val name: String,
    val region: String,
    val country: String
)

data class Current(
    @SerializedName("temp_c") val tempC: Double,
    @SerializedName("precip_mm") val precipMm: Double,
    @SerializedName("wind_dir") val windDir: String,
    @SerializedName("wind_kph") val windKph: Double,
    val condition: Condition
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day
)

data class Day(
    @SerializedName("maxtemp_c") val maxtempC: Double,
    @SerializedName("mintemp_c") val mintempC: Double,
    @SerializedName("totalprecip_mm") val totalprecipMm: Double,
    @SerializedName("daily_chance_of_rain") val dailyChanceOfRain: Int,
    @SerializedName("daily_chance_of_snow") val dailyChanceOfSnow: Int,
    @SerializedName("maxwind_kph") val maxwindKph: Double,
    val avghumidity: Int,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String,
    val code: Int
)