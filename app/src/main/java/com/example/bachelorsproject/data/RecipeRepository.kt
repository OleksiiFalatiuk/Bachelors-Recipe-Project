package com.example.bachelorsproject.data

import com.example.bachelorsproject.model.Recipe

interface RecipeRepository {
    suspend fun loadRecipe(recipeName: String): List<Recipe>
}