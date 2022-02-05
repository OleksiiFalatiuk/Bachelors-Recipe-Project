package com.example.bachelorsproject.data.remote.retrofit

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.data.remote.RemoteDataSource
import com.example.bachelorsproject.model.TotalResults


class RetrofitDataSource(private val api: RecipeApiService):RemoteDataSource {

    override suspend fun loadRecipe(recipeName: String): List<Recipe> {
        val recipe = api.loadImageOfRecipe(recipeName)
        return recipe.results.map {
            Recipe(
                id = it.id,
                imageOfRecipe = formingImage(baseUrl,it.image, size)
            )
        }
    }


    private fun formingImage(url: String?, path: String?, size: String?): String? {
        return if (url == null || path == null) {
            null
        } else {
            url.plus(path.takeUnless { it.isEmpty() } ?: DEFAULT_SIZE).plus(size)
        }
    }

    companion object{
        const val baseUrl = "https://spoonacular.com/recipeImages/"
        const val size = "-90x90.jpg"
        const val DEFAULT_SIZE = "-240x150.jpg"
    }

}