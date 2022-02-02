package com.example.bachelorsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.bachelorsproject.recipe.RecipeListFragment

class MainActivity : AppCompatActivity() {
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
}