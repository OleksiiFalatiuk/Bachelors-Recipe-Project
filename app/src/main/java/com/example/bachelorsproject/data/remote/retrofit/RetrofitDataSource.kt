package com.example.bachelorsproject.data.remote.retrofit

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.data.remote.RemoteDataSource
import com.example.bachelorsproject.model.Component
import com.example.bachelorsproject.model.RecipeInfo


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

    override suspend fun loadRecipeInfoAndComponents(recipeId: Int): RecipeInfo {
        val info = api.loadInfoOfRecipe(recipeId)
        return RecipeInfo(
            recipeId = info.id,
            imageOfRecipeInfo = info.imageOfRecipeInfo,
            recipeNameInfo = info.titleOfRecipeInfo,
            summaryOfRecipeInfo = info.summaryOfRecipeInfo,
            components = info.ingredients.map { component ->
                Component(
                    componentId = component.id,
                    imageOfComponent = formingImage(URL, SIZE, component.imageOfIngredient),
                    titleOfComponent = component.nameOfIngredient,
                    dosesOfComponent = component.doseOfIngredient
                )
            }
        )
    }



    private fun formingImage(url: String?, size: String?, path: String?): String? {
        return if (url == null || path == null) {
            null
        } else {
            url.plus(size).plus(path)
        }
    }

    companion object{
        const val URL = "https://spoonacular.com/cdn/"
        const val SIZE = "ingredients_100x100/"
    }
}