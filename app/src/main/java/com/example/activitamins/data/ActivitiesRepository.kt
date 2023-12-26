package com.example.activitamins.data

import javax.inject.Inject
import javax.inject.Singleton
import com.example.activitamins.data.entity.Activities

@Singleton
class ActivitiesRepository @Inject constructor(private val activitiesDao: ActivitiesDao){
    suspend fun getAll() = activitiesDao.getAll()
    suspend fun insertOne(activity: Activities) = activitiesDao.insertOne(activity)

    suspend fun insertMany(vararg activities: Activities) = activitiesDao.insertMany(*activities)

    companion object {

        // For Singleton instantiation
        @Volatile private var instance: ActivitiesRepository? = null

        fun getInstance(plantDao: ActivitiesDao) =
            instance ?: synchronized(this) {
                instance ?: ActivitiesRepository(plantDao).also { instance = it }
            }
    }
}