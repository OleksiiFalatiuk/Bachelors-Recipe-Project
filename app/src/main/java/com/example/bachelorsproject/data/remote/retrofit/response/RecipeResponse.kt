package com.example.bachelorsproject.data.remote.retrofit.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class RecipeResponse(
    @SerialName("totalResults") val totalResults: Int,
    @SerialName("results") val results: List<ResultsResponse>
)