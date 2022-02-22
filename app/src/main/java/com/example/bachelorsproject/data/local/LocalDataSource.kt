package com.example.bachelorsproject.data.local

import com.example.bachelorsproject.data.local.room.RecipeInfoDbEntity
import com.example.bachelorsproject.model.RecipeInfo

interface LocalDataSource {

    suspend fun loadRecipeInfo(): List<RecipeInfo>

    fun insertRecipeInfo(recipeInfo: RecipeInfo)

}