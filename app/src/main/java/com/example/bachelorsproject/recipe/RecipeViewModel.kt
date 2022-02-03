package com.example.bachelorsproject.recipe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.TotalResults
import kotlinx.coroutines.launch

class RecipeViewModel(private val repository: RecipeRepository): ViewModel() {

    private val _getRecipeLiveData = MutableLiveData<TotalResults>(null)

    val getRecipeLiveData: LiveData<TotalResults> = _getRecipeLiveData

    fun loadRecipe(recipeName: String){
        viewModelScope.launch {
            repository.loadRecipe(recipeName)
        }
    }

}