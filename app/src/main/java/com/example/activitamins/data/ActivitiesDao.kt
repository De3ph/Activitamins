package com.example.activitamins.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.activitamins.data.entity.Activities

@Dao
abstract class ActivitiesDao {

    @Query("SELECT * FROM activities ORDER BY title ASC")
    abstract suspend fun getAll(): List<Activities>

    @Upsert
    abstract suspend fun insertOne(activities: Activities)

    @Upsert
    abstract suspend fun insertMany(vararg activities: Activities)

    @Delete
    abstract suspend fun deleteOne(activities: Activities)
}