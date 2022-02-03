package com.example.bachelorsproject.data

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.TotalResults

interface RecipeRepository {
    suspend fun loadRecipe(recipeName: String): TotalResults
}