package com.example.activitamins.presentation.components.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.activitamins.utils.DateFormatter
import com.example.activitamins.viewModel.ActivitiesViewModel

@SuppressLint("StateFlowValueCalledInComposition")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AttendedActivities(
    activitiesViewModel: ActivitiesViewModel
) {

    val attendedActivities = activitiesViewModel.uiState.value.attendedActivities

    val pagerState = rememberPagerState(
        pageCount = { activitiesViewModel.uiState.value.attendedActivities.size }
    )

    HorizontalPager(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(5.dp),
        state = pagerState
    ) { index ->
        // Our page content
        val date = DateFormatter(attendedActivities[index].date)
        Text(text = attendedActivities[index].title)
        Text(text = " | ")
        Text(text = date)
    }
}