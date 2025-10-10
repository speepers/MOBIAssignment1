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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.MainViewModel

@Composable
fun CurrentWeather(
    modifier: Modifier = Modifier,
    onBack: () -> Unit = {},
    viewModel: MainViewModel = viewModel()
) {
    val weather by viewModel.weather.collectAsState()
    val current = weather?.current

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            current?.let { currentWeather ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(
                        text = currentWeather.date,
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
                            painter = painterResource(id = currentWeather.iconRes),
                            contentDescription = "Cloudy icon",
                            modifier = Modifier.size(120.dp)
                        )

                        Column(
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = "High: ${currentWeather.highTemp}  Low: ${currentWeather.lowTemp}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = "Precipitation: ${currentWeather.precipitationType}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = "Amount: ${currentWeather.precipitationAmount}",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )

                            Text(
                                text = "Probability: ${currentWeather.precipitationProbability}",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )

                            Text(
                                text = "Wind: ${currentWeather.windDirection}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                text = "Speed: ${currentWeather.windSpeed}",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )

                            Text(
                                text = "Humidity: ${currentWeather.humidity}",
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "Condition: ${currentWeather.condition}",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}