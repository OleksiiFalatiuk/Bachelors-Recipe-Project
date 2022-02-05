package com.example.bachelorsproject.data.remote.retrofit

import com.example.bachelorsproject.data.remote.retrofit.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RecipeApiService {
    @GET("recipes/complexSearch?")
    suspend fun loadImageOfRecipe(
        @Query("query") recipe_name: String
    ): RecipeResponse
}