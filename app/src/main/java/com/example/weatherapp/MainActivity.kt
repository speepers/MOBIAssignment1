package com.example.weatherapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DisplayUI(mainViewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayUI(mainViewModel: MainViewModel) {

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
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "CurrentWeather",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = "CurrentWeather") {
                CurrentWeather(mainViewModel)
            }

            composable(route = "DailyForecast") {
                DailyForecast(mainViewModel)
            }

        }
    }
}