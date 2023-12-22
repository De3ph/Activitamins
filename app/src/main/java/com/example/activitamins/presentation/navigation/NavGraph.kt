package com.example.activitamins.presentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.activitamins.presentation.screens.ActivityDetails
import com.example.activitamins.presentation.screens.CreateActivity
import com.example.activitamins.presentation.screens.Explore
import com.example.activitamins.presentation.screens.Favourites
import com.example.activitamins.presentation.screens.Profile
import com.example.activitamins.viewModel.ActivitiesViewModel

@Composable
fun NavGraph(
    ctx: Context,
    navController: NavController,
    startDestination: String? = Screens.ExploreScreen.title,
    activitiesViewModel: ActivitiesViewModel
) {

    NavHost(
        navController = navController as NavHostController,
        startDestination = startDestination!!
    ) {

        composable(Screens.ExploreScreen.title) {
            Explore(navController, activitiesViewModel)
        }
        composable(Screens.CreateActivityScreen.title) {
            CreateActivity(activitiesViewModel)
        }
        composable(Screens.FavouritesScreen.title) {
            Favourites(ctx, activitiesViewModel)
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