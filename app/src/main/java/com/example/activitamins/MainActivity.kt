package com.example.activitamins

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.activitamins.presentation.components.layout.BottomBar
import com.example.activitamins.presentation.components.layout.TopBar
import com.example.activitamins.presentation.navigation.Screens
import com.example.activitamins.presentation.screens.ActivityDetails
import com.example.activitamins.presentation.screens.CreateActivity
import com.example.activitamins.presentation.screens.Explore
import com.example.activitamins.presentation.screens.Favourites
import com.example.activitamins.presentation.screens.Profile
import com.example.activitamins.ui.theme.AppTheme
import com.example.activitamins.viewModel.ActivitiesViewModel

class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController
    private val activitiesViewModel = ActivitiesViewModel()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            Main(
                navController = navController
            ) {
                NavHost(
                    navController = navController as NavHostController,
                    startDestination = Screens.ExploreScreen.title
                ) {

                    composable(Screens.ExploreScreen.title) {
                        Explore(navController, activitiesViewModel)
                    }
                    composable(Screens.CreateActivityScreen.title) {
                        CreateActivity(activitiesViewModel)
                    }
                    composable(Screens.FavouritesScreen.title) {
                        Favourites(this@MainActivity, activitiesViewModel)
                    }
                    composable(Screens.ProfileScreen.title) {
                        Profile(activitiesViewModel = activitiesViewModel)
                    }
                    composable("details/{index}",
                        arguments = listOf(
                            navArgument("index") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        ActivityDetails(index = it.arguments?.getString("index")!!, activitiesViewModel)
                    }
                }
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    navController: NavController,
    content: @Composable () -> Unit
) {
    AppTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopBar(navController = navController, title = "Activitamins")
            },
            bottomBar = {
                BottomBar(navController)
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(
                        it
                    ),
            ) {
                content()
            }
        }
    }
}
