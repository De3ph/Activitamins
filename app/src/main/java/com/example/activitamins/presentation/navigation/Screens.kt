package com.example.activitamins.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screens(
    val id: Int,
    val title: String,
    val defaultIcon: ImageVector?,
    val activeIcon: ImageVector?
) {
    object ExploreScreen : Screens(
        1, "Explore", Icons.Outlined.Search, Icons.Outlined.Search
    )

    object CreateActivityScreen :
        Screens(3, "Create Activity", Icons.Outlined.Add, Icons.Outlined.Add)

    object FavouritesScreen :
        Screens(2, "Favourites", Icons.Outlined.FavoriteBorder, Icons.Outlined.Favorite)

    object ProfileScreen : Screens(4, "Profile", Icons.Outlined.Person, Icons.Filled.Person)

    object DetailsScreen : Screens(5,"Details", null, null)
}

val ScreensList = listOf(
    Screens.ExploreScreen,
    Screens.CreateActivityScreen,
    Screens.FavouritesScreen,
    Screens.ProfileScreen
)