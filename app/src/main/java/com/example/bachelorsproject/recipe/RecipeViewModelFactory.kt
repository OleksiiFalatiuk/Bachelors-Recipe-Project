package com.example.bachelorsproject.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bachelorsproject.data.RecipeRepository

class RecipeViewModelFactory(private val repository: RecipeRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T = RecipeViewModel(repository) as T
}