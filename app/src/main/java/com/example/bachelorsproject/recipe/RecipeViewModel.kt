package com.example.bachelorsproject.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.model.Recipe
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository) : ViewModel() {

    private val _getRecipeLiveData = MutableLiveData<List<Recipe>>(null)

    val getRecipeLiveData: LiveData<List<Recipe>> = _getRecipeLiveData

    fun loadRecipe(recipeName: String) {
        viewModelScope.launch {
            try {
                _getRecipeLiveData.value = repository.loadRecipe(recipeName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
