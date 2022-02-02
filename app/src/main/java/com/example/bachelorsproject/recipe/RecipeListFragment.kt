package com.example.bachelorsproject.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bachelorsproject.R

class RecipeListFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recipe_list,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val edit = view.findViewById<EditText>(R.id.etForRecipe)
        val button = view.findViewById<Button>(R.id.btnClick)

        button.setOnClickListener {
            edit.text.toString()

        }


    }



    companion object{
        fun create() = RecipeListFragment()
    }
}