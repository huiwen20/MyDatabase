package com.example.mydatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface FeelingDao {
    @Insert
    // suspend is a coroutine function
    // execute as separate thread, as background process
    suspend fun insertFeeling(feeling: Feeling)

    @Update
    suspend fun updateFeeling(feeling: Feeling)

    @Delete
    suspend fun deleteFeeling(feeling: Feeling)

    // retrieve all records
    @Query("SELECT * FROM feeling")
    // return a LiveData with a list of feeling
    // suspend fun getAllRecords(): LiveData<List<Feeling>>
    fun getAllRecords(): LiveData<List<Feeling>>

    // retrieve some records
    @Query("SELECT * FROM feeling WHERE id = :search_id")
    //suspend fun getOneRecord(search_id:Int)
    fun getOneRecord(search_id:Int): Feeling
}