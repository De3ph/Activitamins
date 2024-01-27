package com.example.activitamins.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.activitamins.presentation.components.ui.ActivityCard
import com.example.activitamins.presentation.components.ui.PageTitle
import com.example.activitamins.viewModel.ActivitiesViewModel

@Composable
fun Explore(
    navController: NavController,
    favouritesViewModel: ActivitiesViewModel
) {

    val activities = favouritesViewModel.uiState.collectAsState().value.activities

    LazyColumn(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
            ) {
                PageTitle(title = "Explore")
            }
        }

        items(activities.size) {

            ActivityCard(
                index = it,
                title = activities[it].title,
                date = activities[it].date,
                organizer = activities[it].organizer,
                isFavourite = activities[it].isFavourite,
                tag = activities[it].tag,
                navController = navController,
                toggleFavourite = favouritesViewModel::toggleFavourite
            )
        }
    }
}