package com.example.bachelorsproject.recipeorder

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bachelorsproject.R
import com.example.bachelorsproject.recipe.RecipeListFragment

class RecipeOrderFragment: Fragment() {


    private var listenerForPay: RecipePayClickListener? = null

    override fun onAttach(context: Context) {


        if (context is RecipePayClickListener){
            listenerForPay = context
        }
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_recipe_order, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonPay = view.findViewById<Button>(R.id.pay)

        buttonPay.setOnClickListener {
            listenerForPay?.onRecipePaySelected()
        }
    }

    override fun onDetach() {
        listenerForPay = null
        super.onDetach()
    }

    interface RecipePayClickListener {
        fun onRecipePaySelected()
    }


    companion object{
        fun create() = RecipeOrderFragment()
    }
}