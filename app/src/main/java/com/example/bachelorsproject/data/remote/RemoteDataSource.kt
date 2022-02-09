package com.example.bachelorsproject.data.remote

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.RecipeInfo

interface RemoteDataSource {
      suspend fun loadRecipe(recipeName: String): List<Recipe>
      suspend fun loadRecipeInfoAndComponents(recipeId: Int): RecipeInfo
}