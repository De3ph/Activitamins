package com.example.activitamins.data.dto

import com.example.activitamins.data.Tag
import com.example.activitamins.data.entity.Activities
import io.mcarle.konvert.api.KonvertTo
import java.util.Date

@KonvertTo(Activities::class)
data class ActivitiesDto(
    var title: String,
    var date: Date,
    var description: String,
    var organizer: String,
    var isFavourite: Boolean = false,
    var attendedUserNumber: Int = 0,
    var isUserAttended: Boolean = false,
    var tag: Tag
)
