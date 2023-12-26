package com.example.activitamins.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.activitamins.data.ActivitiesData
import com.example.activitamins.data.ActivitiesRepository
import com.example.activitamins.data.dto.ActivitiesDto
import com.example.activitamins.data.dto.toActivities
import com.example.activitamins.data.dummyData
import com.example.activitamins.data.entity.Activities
import com.example.activitamins.data.entity.toActivitiesDto
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.Date
import javax.inject.Inject

data class ActivitiesUiState(
    val activities: List<ActivitiesDto> = emptyList(),
    val attendedActivities: List<ActivitiesDto> = activities.filter { it.isUserAttended },
)

@HiltViewModel
class ActivitiesViewModel @Inject constructor(
    private val repository: ActivitiesRepository
) : ViewModel() {
    private lateinit var _uiState: MutableStateFlow<ActivitiesUiState>

    init {
        viewModelScope.launch {
            runBlocking {
                if (repository.getAll().isEmpty()) {
                    repository.insertMany(*dummyData)
                }

                _uiState = MutableStateFlow(
                    ActivitiesUiState(
                        activities = repository.getAll().map { it.toActivitiesDto() },
                        attendedActivities = repository.getAll().map { it.toActivitiesDto() }
                            .filter { it.isUserAttended },
                    )
                )
            }
        }
    }

    val uiState = _uiState.asStateFlow()


    fun addActivity(activity: ActivitiesDto) {

        viewModelScope.launch {
            repository.insertOne(
                activity.toActivities()
            )

            _uiState.update { currentState ->
                currentState.copy(
                    activities = repository.getAll().map { it.toActivitiesDto() },
                )
            }
        }

    }

    fun toggleAttendActivity(activityIndex: Int) {
        _uiState.update { currentState ->
            currentState.activities[activityIndex].isUserAttended =
                !(currentState.activities[activityIndex].isUserAttended)

            if (currentState.activities[activityIndex].isUserAttended) {
                currentState.activities[activityIndex].attendedUserNumber += 1
            } else {
                currentState.activities[activityIndex].attendedUserNumber -= 1
            }

            currentState.copy(
                activities = currentState.activities,
                attendedActivities = currentState.activities.filter { it.isUserAttended },
            )
        }
    }

    fun toggleFavourite(index: Int) {
        _uiState.update { currentState ->
            currentState.activities[index].isFavourite = !currentState.activities[index].isFavourite

            currentState.copy(
                activities = currentState.activities,
            )
        }
    }
}