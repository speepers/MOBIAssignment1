package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisplayUI()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(){

    val navController = rememberNavController()
    var selectedItem by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                title = {
                    Text("Halifax, Nova Scotia")
                }

            )
        },
        bottomBar = {
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                NavigationBarItem(
                    label = {
                        Text("Today's Weather")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_clouds),
                            contentDescription = "Clouds Icon"
                        )
                    },
                    selected = selectedItem == 0,
                    onClick = {
                        selectedItem = 0
                        navController.navigate(route = "CurrentWeather")
                    }
                )

                NavigationBarItem(
                    label = {
                        Text("Home")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_home),
                            contentDescription = "Home Icon"
                        )
                    },
                    selected = selectedItem == 1,
                    onClick = {
                        selectedItem = 1
                        navController.navigate(route = "AppContent")
                    }
                )

                NavigationBarItem(
                    label = {
                        Text("Daily Forecast")
                    },
                    icon = {
                        Icon(
                            painter = painterResource(R.drawable.ic_action_calendar),
                            contentDescription = "Calendar Icon"
                        )
                    },
                    selected = selectedItem == 2,
                    onClick = {
                        selectedItem = 2
                        navController.navigate(route = "DailyForecast")
                    }
                )
            }
        }
    ){ innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "AppContent",
            modifier = Modifier.padding(innerPadding)
        ){
            composable(route = "CurrentWeather") {
                CurrentWeather()
            }

            composable(route = "DailyForecast"){
                DailyForecast()
            }

            composable(route = "AppContent") {
                AppContent()
            }
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
                        .padding(top = 50.dp),
                        style = TextStyle(fontSize = 40.sp),
                        fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center
                )

                Column(){
                    Box(modifier = Modifier.fillMaxSize()) {
                        Column(
                            modifier = Modifier
                                .align(Alignment.TopCenter)    // place the whole column where you want in the Box
                                .padding(top = 230.dp),        // move both image+text down together
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.cloudy),
                                contentDescription = "Cloudy icon",
                                modifier = Modifier.size(120.dp)
                            )

                            Spacer(modifier = Modifier.height(16.dp)) // space between image and text

                            Text(
                                text = "Currently 18\u00B0C",
                                style = TextStyle(fontSize = 30.sp)
                            )
                        }
                    }
                }
            }
        }
    }
}
