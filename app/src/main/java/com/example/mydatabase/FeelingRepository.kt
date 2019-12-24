package com.example.mydatabase

import androidx.lifecycle.LiveData

// from android room in kotlin
// this repository will get feelingDao
class FeelingRepository (private val feelingDao: FeelingDao){

    val allFeelings: LiveData<List<Feeling>> = feelingDao.getAllRecords()

    suspend fun insertFeeling(feeling: Feeling){
        feelingDao.insertFeeling(feeling)
    }
}