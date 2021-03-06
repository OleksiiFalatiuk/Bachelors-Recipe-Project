package com.example.bachelorsproject.model

data class RecipeInfo(
    val recipeId: Int,
    val imageOfRecipeInfo: String?,
    val recipeNameInfo: String,
    val summaryOfRecipeInfo: String,
    val pricePerServing: Double?,
    val components: List<Component>
)
