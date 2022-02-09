package com.example.bachelorsproject.data

import com.example.bachelorsproject.data.remote.RemoteDataSource
import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.RecipeInfo

class RecipeRepositoryImpl(private val remote: RemoteDataSource): RecipeRepository {

    override suspend fun loadRecipe(recipeName: String): List<Recipe> {
        return remote.loadRecipe(recipeName)
    }

    override suspend fun loadRecipeInfoAndComponents(recipeId: Int): RecipeInfo {
        return remote.loadRecipeInfoAndComponents(recipeId)
    }
}