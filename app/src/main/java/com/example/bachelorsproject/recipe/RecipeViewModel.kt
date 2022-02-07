package com.example.bachelorsproject.recipe

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.TotalResults
import kotlinx.coroutines.launch
import retrofit2.HttpException

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
