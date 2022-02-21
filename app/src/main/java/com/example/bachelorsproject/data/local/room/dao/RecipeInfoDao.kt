package com.example.bachelorsproject.data.local.room.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.bachelorsproject.data.local.room.RecipeInfoDbEntity

interface RecipeInfoDao {

    @Transaction
    @Query("SELECT * FROM RecipeInfo")
    fun getMovies(): List<RecipeInfoDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: RecipeInfoDbEntity)

}