package com.example.bachelorsproject.provider

import com.example.bachelorsproject.data.RecipeRepository


interface RecipeProvider {
    fun provideRecipe(): RecipeRepository
}