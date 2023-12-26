package com.example.activitamins.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.activitamins.data.dto.ActivitiesDto
import io.mcarle.konvert.api.KonvertTo
import java.util.Date

@Entity(tableName = "activities")
@KonvertTo(ActivitiesDto::class)
class Activities(
    var title: String,
    var date: Date,
    var description: String,
    var organizer: String,
    var isFavourite: Boolean = false,
    var attendedUserNumber: Int = 0,
    var isUserAttended: Boolean = false
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}