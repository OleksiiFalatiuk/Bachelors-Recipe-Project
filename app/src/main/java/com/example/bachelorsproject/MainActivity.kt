package com.example.bachelorsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.data.RecipeRepositoryImpl
import com.example.bachelorsproject.data.remote.retrofit.RetrofitDataSource
import com.example.bachelorsproject.provider.NetworkModule
import com.example.bachelorsproject.provider.RecipeProvider
import com.example.bachelorsproject.recipe.RecipeListFragment

class MainActivity : AppCompatActivity(), RecipeProvider {

    private val networkModule = NetworkModule()
    private val retrofitDataSource = RetrofitDataSource(networkModule.api)
    private val recipeRepository = RecipeRepositoryImpl(retrofitDataSource)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .add(
                    R.id.flMain,
                    RecipeListFragment.create(),
                    RecipeListFragment::class.java.simpleName
                )
                .addToBackStack("trans:${RecipeListFragment::class.java.simpleName}")
                .commit()
        }
    }

    override fun provideRecipe(): RecipeRepository = recipeRepository
}