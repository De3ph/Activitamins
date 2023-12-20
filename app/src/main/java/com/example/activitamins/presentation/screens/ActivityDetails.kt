package com.example.activitamins.presentation.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

    val scrollState = rememberScrollState()

    val activity = activitiesViewModel.uiState.collectAsState().value.activities[index.toInt()]

    // activity.isUserAttended a göre attendState i değiştiriyoruz, buton text'i ve toast mesajı için
    val attendState by remember(activity.isUserAttended) {
        derivedStateOf {
            if (activity.isUserAttended) "Unattend" else "Attend"
        }
    }

    val date = DateFormatter(activity.date)


    val attendedToast = Toast.makeText(LocalContext.current, "${attendState}ed", Toast.LENGTH_SHORT)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 10.dp)
            .verticalScroll(scrollState),

        verticalArrangement = Arrangement.spacedBy(30.dp)

    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Row {
                PageTitle("Details of ${activity.title}")
            }
            Row {
                Text(
                    text = activity.attendedUserNumber.toString(),
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = " people attended to this activity",
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