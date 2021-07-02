package com.example.mvvm.storage.persistence

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tableExample")
data class ExampleEntity(
    @PrimaryKey(autoGenerate = false)
    val exampleString: String,
    val exampleInt: Int,
    val exampleBoolean: Boolean
)