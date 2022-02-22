package com.example.bachelorsproject.data.local.room

import com.example.bachelorsproject.data.local.LocalDataSource
import com.example.bachelorsproject.model.RecipeInfo

class RoomData(private val appDb: AppDataBase): LocalDataSource {

    override suspend fun loadRecipeInfo(): List<RecipeInfo> {
        return appDb.getRecipeInfoDao().getRecipeInfo().map {
            RecipeInfo(
                recipeId = it.id,
                imageOfRecipeInfo = it.image,
                pricePerServing = it.price,
                recipeNameInfo = it.recipeName,
                summaryOfRecipeInfo = "",
                components = emptyList()
            )
        }
    }

    override fun insertRecipeInfo(recipeInfo: RecipeInfo) {
        val recipeBase = RecipeInfoDbEntity(
            id = recipeInfo.recipeId,
            image = recipeInfo.imageOfRecipeInfo,
            recipeName = recipeInfo.recipeNameInfo,
            price = recipeInfo.pricePerServing
        )
        appDb.getRecipeInfoDao().insertRecipeInfo(recipeBase)
    }
}