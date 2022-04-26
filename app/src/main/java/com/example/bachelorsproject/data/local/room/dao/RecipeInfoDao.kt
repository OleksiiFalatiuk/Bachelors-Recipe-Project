package com.example.bachelorsproject.data.local.room.dao

import androidx.room.*
import com.example.bachelorsproject.data.local.room.RecipeInfoDbEntity
@Dao
interface RecipeInfoDao {

    @Transaction
    @Query("SELECT * FROM RecipeInfo")
    fun getRecipeInfo(): List<RecipeInfoDbEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecipeInfo(movies: RecipeInfoDbEntity)

}