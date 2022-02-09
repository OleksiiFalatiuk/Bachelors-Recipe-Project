package com.example.bachelorsproject.recipeinfo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bachelorsproject.data.RecipeRepository

class RecipeInfoViewModelFactory(private val repository: RecipeRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T = RecipeInfoViewModel(repository) as T
}