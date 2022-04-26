package com.example.bachelorsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bachelorsproject.data.RecipeRepository
import com.example.bachelorsproject.data.RecipeRepositoryImpl
import com.example.bachelorsproject.data.remote.retrofit.RetrofitDataSource
import com.example.bachelorsproject.provider.NetworkModule
import com.example.bachelorsproject.provider.RecipeProvider
import com.example.bachelorsproject.recipe.RecipeListFragment
import com.example.bachelorsproject.recipeinfo.RecipeInfoListFragment
import com.example.bachelorsproject.recipeorder.RecipeOrderFragment
import com.example.bachelorsproject.recipepay.RecipePayFragment
import kotlinx.serialization.ExperimentalSerializationApi

class MainActivity : AppCompatActivity(),
    RecipeListFragment.RecipeListItemClickListener, RecipeListFragment.RecipeOrderClickListener, RecipeOrderFragment.RecipePayClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
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

    override fun onRecipeSelected(recipeId: Int) {
        toRecipeInfoFragment(recipeId)
    }

    private fun toRecipeInfoFragment(recipeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flMain,
                RecipeInfoListFragment.create(recipeId),
                RecipeInfoListFragment::class.java.simpleName
            )
            .addToBackStack("trans:${RecipeInfoListFragment::class.java.simpleName}")
            .commit()
    }

    private fun toRecipeOrderFragment(){
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flMain,
                RecipeOrderFragment.create(),
                RecipeOrderFragment::class.java.simpleName
            )
            .addToBackStack("trans:${RecipeOrderFragment::class.java.simpleName}")
            .commit()
    }

    override fun onRecipeOrderSelected() {
        toRecipeOrderFragment()
    }

    private fun toRecipePayFragment(){
        supportFragmentManager.beginTransaction()
            .replace(
                R.id.flMain,
                RecipePayFragment.create(),
                RecipePayFragment::class.java.simpleName
            )
            .addToBackStack("trans:${RecipePayFragment::class.java.simpleName}")
            .commit()
    }

    override fun onRecipePaySelected() {
        toRecipePayFragment()
    }


}