package com.example.bachelorsproject.data.local.room

import androidx.room.*

@Entity(tableName = "RecipeInfo")
data class RecipeInfoDbEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,
    val image: String?,
    val recipeName: String,
    val price: Double
)