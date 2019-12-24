package com.example.mydatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// from android room in kotlin
// pass application as parameter
class FeelingViewModel (application: Application): AndroidViewModel(application){
    private val repository: FeelingRepository

    val allFeelings : LiveData<List<Feeling>>

    // like constructor
    init {
        val feelingDao = FeelingDatabase.getDatabase(application).feelingDao()
        repository = FeelingRepository(feelingDao)
        allFeelings = repository.allFeelings
    }

    // a coroutine function
    // globalScope : launch coroutine
    fun insert(feeling: Feeling) = viewModelScope.launch {
        repository.insertFeeling(feeling)
    }
}