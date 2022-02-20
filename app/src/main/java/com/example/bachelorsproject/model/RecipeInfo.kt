package com.example.bachelorsproject.model

data class RecipeInfo(
    val recipeId: Int,
    val imageOfRecipeInfo: String?,
    val recipeNameInfo: String,
    val summaryOfRecipeInfo: String,
    val pricePerServing: Float,
    val components: List<Component>
)
