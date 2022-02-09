package com.example.bachelorsproject.data

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.RecipeInfo

interface RecipeRepository {
    suspend fun loadRecipe(recipeName: String): List<Recipe>
    suspend fun loadRecipeInfoAndComponents(recipeId: Int): RecipeInfo
}