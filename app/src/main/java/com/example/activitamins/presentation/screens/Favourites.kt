package com.example.activitamins.presentation.screens

import android.content.Context
import android.content.Intent
import android.provider.CalendarContract
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.example.activitamins.data.ActivitiesData
import com.example.activitamins.data.dto.ActivitiesDto
import com.example.activitamins.presentation.components.ui.PageTitle
import com.example.activitamins.viewModel.ActivitiesViewModel
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar


@Composable
fun Favourites(
    context: Context,
    favouritesViewModel: ActivitiesViewModel
) {

    val favourites = favouritesViewModel.uiState.collectAsState().value.activities.filter { it.isFavourite }

    fun createCalendarIntent(
        activity: ActivitiesDto,
        location: String
    ): Intent {

        // calendar intent with random date and time
        val calIntent = Intent(Intent.ACTION_INSERT, CalendarContract.Events.CONTENT_URI).apply {
            val date = LocalDateTime.ofInstant(activity.date.toInstant(),ZoneId.of("UTC"))

            val beginTime: Calendar = Calendar.getInstance().apply {
                set(
                    date.year,
                    date.monthValue,
                    date.dayOfMonth,
                    date.hour,
                    date.second
                )
            }
            val endTime = Calendar.getInstance().apply {
                set(
                    date.year,
                    date.monthValue,
                    date.dayOfMonth,
                    date.hour + 1,
                    date.second
                )
            }
            putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.timeInMillis)
            putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.timeInMillis)
            putExtra(CalendarContract.Events.TITLE, activity.title)
            putExtra(CalendarContract.Events.EVENT_LOCATION, location)
        }

        return calIntent
    }


    Column(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .padding(
                horizontal = 5.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            PageTitle(title = "Favourites")
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .padding(top = 45.dp),

            ) {
            favourites.map {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = it.title,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.SemiBold
                            )
                        )
                        Button(
                            modifier = Modifier,
                            shape = MaterialTheme.shapes.extraSmall,
                            onClick = {
                                val intent = createCalendarIntent(it, "Home")

                                startActivity(context, intent, null)
                            }) {
                            Text(text = "Add to Calendar")
                        }
                    }
                }
            }
        }
    }
}
