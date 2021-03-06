package com.example.mydatabase

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

// If no table name will same as class name
@Entity(tableName = "feeling")
data class Feeling (
    @PrimaryKey (autoGenerate = true) val id: Int,
    val mode: Int,
    val remarks: String,
    val created_at: Long = System.currentTimeMillis()
)