package com.example.bachelorsproject.recipeinfo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.model.RecipeInfo
import kotlinx.coroutines.launch
import java.lang.Exception

class RecipeInfoViewModel(private val repository: RecipeRepository): ViewModel() {

    private val _getRecipeInfoLiveData = MutableLiveData<RecipeInfo>(null)

    val getRecipeInfoLiveData: LiveData<RecipeInfo> =_getRecipeInfoLiveData

    fun loadRecipeInfoAndComponents(recipeId: Int) {
        viewModelScope.launch {
            try {
                _getRecipeInfoLiveData.value = repository.loadRecipeInfoAndComponents(recipeId)
            } catch(e: Exception){
                e.printStackTrace()
            }
        }
    }

}