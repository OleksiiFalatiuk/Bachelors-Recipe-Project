package com.example.bachelorsproject.data.remote.retrofit.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ExtendedIngredientsResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val nameOfIngredient: String,
    @SerialName("image") val imageOfIngredient: String?,
    @SerialName("original") val doseOfIngredient: String
)