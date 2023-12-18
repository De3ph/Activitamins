package com.example.activitamins.presentation.components.layout

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.activitamins.presentation.navigation.ScreensList

@Composable
fun BottomBar(
    navController: NavController
) {

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry.value?.destination?.route

    NavigationBar(
        modifier = Modifier
    )
    {
        ScreensList.map {

            val isActive = currentDestination === it.title

            NavigationBarItem(
                selected = isActive,
                onClick = { navController.navigate(it.title) },
                alwaysShowLabel = false,
                label = {
                    Text(text = it.title)
                },
                icon = {
                    Icon(
                        // !! -> not null assertment, ensures the compiler this value not null and converts nullable value to non-null value
                        imageVector = (if (isActive) it.activeIcon else it.defaultIcon)!!,
                        contentDescription = "${it.title} icon",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                },
                colors = NavigationBarItemDefaults
                    .colors(
                        indicatorColor = MaterialTheme.colorScheme.surface
                    )
            )
        }
    }
}
