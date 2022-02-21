package com.example.bachelorsproject.data.remote.retrofit.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RecipeInfoResponse(
    @SerialName("id") val id: Int,
    @SerialName("title") val titleOfRecipeInfo: String,
    @SerialName("image") val imageOfRecipeInfo: String?,
    @SerialName("summary") val summaryOfRecipeInfo: String,
    @SerialName("pricePerServing") val pricePerServing: Double?,
    @SerialName("extendedIngredients") val ingredients: List<ExtendedIngredientsResponse>
)