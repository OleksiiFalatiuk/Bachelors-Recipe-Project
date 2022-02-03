package com.example.bachelorsproject.data.remote.retrofit.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class ResultsResponse(
    @SerialName("id") val id: Int,
    @SerialName("image") val image: String
)