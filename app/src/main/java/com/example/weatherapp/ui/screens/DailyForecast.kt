package com.example.weatherapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weatherapp.R

@Composable
fun DailyForecast(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onBack,
                modifier = Modifier.size(width = 100.dp, height = 50.dp),
            ) {
                Text("Back")
            }
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                // Day 1 - Today
                DayForecastItem(
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
                )

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color.Gray
                )

                // Day 2 - Tomorrow
                DayForecastItem(
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
                )

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    thickness = 1.dp,
                    color = Color.Gray
                )

                // Day 3
                DayForecastItem(
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
            }
        }
    }
}

@Composable
fun DayForecastItem(
    date: String,
    highTemp: String,
    lowTemp: String,
    condition: String,
    precipitationType: String,
    precipitationAmount: String,
    precipitationProbability: String,
    windDirection: String,
    windSpeed: String,
    humidity: String,
    iconRes: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Text(
            text = date,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = "$condition icon",
                modifier = Modifier.size(120.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "High: $highTemp  Low: $lowTemp",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Precipitation: $precipitationType",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Amount: $precipitationAmount",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = "Probability: $precipitationProbability",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = "Wind: $windDirection",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = "Speed: $windSpeed",
                    fontSize = 14.sp,
                    color = Color.Gray
                )

                Text(
                    text = "Humidity: $humidity",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Condition: $condition",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}