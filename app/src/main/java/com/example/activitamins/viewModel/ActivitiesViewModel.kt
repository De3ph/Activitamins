package com.example.activitamins.viewModel

import androidx.lifecycle.ViewModel
import com.example.activitamins.data.Activities
import com.example.activitamins.data.allActivities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

data class ActivitiesUiState(
    val activities: List<Activities> =
        allActivities,
    val attendedActivities: List<Activities> = activities.filter { it.isUserAttended },
    val nextActivityId : Int = allActivities.size
)

@HiltViewModel
class ActivitiesViewModel @Inject constructor(): ViewModel() {
    private val _uiState = MutableStateFlow(ActivitiesUiState())

    val uiState = _uiState.asStateFlow()

    fun addActivity(activity: Activities) {

        _uiState.update { currentState ->
            currentState.copy(
                activities = currentState.activities + activity,
                attendedActivities = currentState.activities.filter { it.isUserAttended },
                nextActivityId = currentState.activities.size
            )
        }
    }

    fun toggleAttendActivity(activityIndex: Int) {
        _uiState.update { currentState ->
            currentState.activities[activityIndex].isUserAttended =
                !(currentState.activities[activityIndex].isUserAttended)

            if (currentState.activities[activityIndex].isUserAttended) {
                currentState.activities[activityIndex].attendedUserNumber += 1
            }else{
                currentState.activities[activityIndex].attendedUserNumber -= 1
            }

            currentState.copy(
                activities = currentState.activities,
                attendedActivities = currentState.activities.filter { it.isUserAttended },
                nextActivityId = currentState.activities.size
            )
        }
    }

    fun toggleFavourite(index: Int) {
        _uiState.update { currentState ->
            currentState.activities[index].isFavourite = !currentState.activities[index].isFavourite

            currentState.copy(
                activities = currentState.activities,
                attendedActivities = currentState.activities.filter { it.isUserAttended },
                nextActivityId = currentState.activities.size
            )
        }
    }
}