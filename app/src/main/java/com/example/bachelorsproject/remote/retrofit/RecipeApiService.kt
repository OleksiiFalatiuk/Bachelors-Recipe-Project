package com.example.bachelorsproject.remote.retrofit

import com.example.bachelorsproject.remote.retrofit.response.RecipeResponse
import retrofit2.http.GET
import retrofit2.http.Path


interface RecipeApiService {
    @GET("recipes/complexSearch?{recipe_name}")
    suspend fun loadImageOfRecipe(
        @Path("recipe_name") recipe_name: String?
    ): RecipeResponse
}