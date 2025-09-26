package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.weatherapp.ui.screens.CurrentWeather
import com.example.weatherapp.ui.screens.DailyForecast
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    var showWeather by rememberSaveable { mutableStateOf(false) }
    var showDailyWeather by rememberSaveable { mutableStateOf(false) }

    when {
        showWeather -> CurrentWeather(onBack = { showWeather = false })
        showDailyWeather -> DailyForecast(onBack = { showDailyWeather = false })
        else -> {
            Box(modifier = Modifier.fillMaxSize()) {

                Text(
                    text = "The Weather Channel",
                    modifier = Modifier
                        .align(Alignment.TopCenter)
                        .padding(top = 100.dp),
                        style = TextStyle(fontSize = 40.sp),
                        fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center
                )

                Column(

                ){
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopCenter)    // place the whole column where you want in the Box
                                .padding(top = 200.dp),        // move both image+text down together
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cloudy),
                                contentDescription = "Cloudy icon",
                                modifier = Modifier.size(120.dp)
                            )

                            Spacer(modifier = Modifier.height(8.dp)) // space between image and text

                            Text(
                                text = "Currently 18\u00B0C",
                                style = TextStyle(fontSize = 20.sp)
                            )
                        }
                    }
                }

                Row(
                    modifier = Modifier.align(Alignment.Center)
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { showWeather = true },
                        modifier = Modifier.size(80.dp),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "Today's Forecast",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(
                        onClick = { showDailyWeather = true },
                        modifier = Modifier.size(80.dp),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "3-Day Forecast",
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis
                            )
                        }
                    }
                }
            }
        }
    }
}
