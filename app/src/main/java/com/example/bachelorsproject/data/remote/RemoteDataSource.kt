package com.example.bachelorsproject.data.remote

import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.TotalResults

interface RemoteDataSource {
//    suspend fun loadSome(recipeName: String): List<TotalResults>
      suspend fun loadRecipe(recipeName: String): List<Recipe>
}