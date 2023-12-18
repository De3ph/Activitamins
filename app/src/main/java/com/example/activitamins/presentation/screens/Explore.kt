package com.example.activitamins.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 10.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            PageTitle("Explore")
        }


        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ){
            items(activities.size){
                ActivityCard(
                    index = it,
                    title = activities[it].title,
                    date = activities[it].date,
                    organizer = activities[it].organizer,
                    isFavourite = activities[it].isFavourite,
                    navController = navController,
                    toggleFavourite = favouritesViewModel::toggleFavourite
                )
            }
        }
    }
}