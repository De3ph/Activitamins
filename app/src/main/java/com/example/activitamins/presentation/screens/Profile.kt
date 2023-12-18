package com.example.activitamins.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.activitamins.R
import com.example.activitamins.presentation.components.ui.AttendedActivities
import com.example.activitamins.presentation.components.ui.ProfilePhoto
import com.example.activitamins.viewModel.ActivitiesViewModel

@Composable
fun Profile(
    activitiesViewModel: ActivitiesViewModel
) {
    val state = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .verticalScroll(state)
        ,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {

        Row(
            Modifier.fillMaxWidth(0.5f),
            horizontalArrangement = Arrangement.Center,
        ) {
            ProfilePhoto(photo = R.drawable.profile, label = "John Doe")
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Personal Informations",
                        style = MaterialTheme.typography.titleMedium
                    )
                }

                Divider(
                    modifier = Modifier.padding(vertical = 5.dp),
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(text = "Age: 25", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Height: 180cm", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Weight: 80kg", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "BMI: 24.7", style = MaterialTheme.typography.bodyMedium)
                    Text(text = "Blood Type: A+", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Column {
                    Text(text = "Attended activities", style = MaterialTheme.typography.titleMedium)
                    Row(
                        Modifier.fillMaxWidth().height(150.dp)
                    ) {
                        AttendedActivities(activitiesViewModel = activitiesViewModel)
                    }
                }
            }
        }

    }
}