package com.example.activitamins.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.activitamins.R
import com.example.activitamins.presentation.components.ui.PageTitle
import com.example.activitamins.utils.DateFormatter
import com.example.activitamins.viewModel.ActivitiesViewModel

@Composable
fun ActivityDetails(
    index: String,
    activitiesViewModel: ActivitiesViewModel
) {

    val activity = activitiesViewModel.uiState.collectAsState().value.activities[index.toInt()]
    val date = DateFormatter(activity.date)
    val attendState by remember {
        derivedStateOf {
            if (activity.isUserAttended) "Unattend" else "Attend"
        }
    }

    val attendedToast = Toast.makeText(LocalContext.current, "Attended,", Toast.LENGTH_LONG)
    attendedToast.verticalMargin.plus(100)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp),

        verticalArrangement = Arrangement.spacedBy(30.dp)

    ) {
        Column {
            Row {
                PageTitle("Details of ${activity.title}")
            }
            Row {
                Text(
                    text = activity.attendedUserNumber.toString(),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = " people attended this activity",
                    style = MaterialTheme.typography.labelLarge.copy(
                        color = Color.Gray
                    )
                )
            }
        }

        Row {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Description: ${activity.description}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Start Date: $date",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = "Organizer: ${activity.organizer}",
                    style = MaterialTheme.typography.bodyLarge
                )

            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                painter = painterResource(id = R.drawable.activity1),
                contentDescription = "activity image"
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                shape = RectangleShape,
                onClick = {
                    activitiesViewModel.toggleAttendActivity(index.toInt())
                    attendedToast.show()
                }) {
                Text(
                    text = attendState,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }

}