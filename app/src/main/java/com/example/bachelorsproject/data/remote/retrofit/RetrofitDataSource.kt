package com.example.bachelorsproject.data.remote.retrofit

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.data.remote.RemoteDataSource


class RetrofitDataSource(private val api: RecipeApiService):RemoteDataSource {

    override suspend fun loadRecipe(recipeName: String): List<Recipe> {
        val recipe = api.loadImageOfRecipe(recipeName)
        return recipe.results.map {
            Recipe(
                id = it.id,
                imageOfRecipe = it.image
            )
        }
    }



}