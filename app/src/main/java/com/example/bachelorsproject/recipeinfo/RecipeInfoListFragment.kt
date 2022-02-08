package com.example.bachelorsproject.recipeinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bachelorsproject.R
import com.example.bachelorsproject.model.RecipeInfo

class RecipeInfoListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recipe_info,container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val recipeId = arguments?.getSerializable(PARAM_RECIPE_DATA) as? Int ?: return

        view.findViewById<RecyclerView>(R.id.recycler_ingredients).apply {
            this.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL,false)

            this.adapter = RecipeInfoAdapter()

            this.adapter = adapter
        }
    }

    private fun updateRecipeInfo(recipe: RecipeInfo){
        val context = view?.context
        if (context != null) {
            view?.findViewById<ImageView>(R.id.imageRecipe)?.let {
                Glide.with(context).load(recipe.imageOfRecipeInfo).into(
                    it
                )
            }
        }
        view?.findViewById<TextView>(R.id.recipe_name_text)?.text = recipe.recipeNameInfo
        view?.findViewById<TextView>(R.id.story_of_summary)?.text = recipe.summaryOfRecipeInfo
    }

    companion object {
        private const val PARAM_RECIPE_DATA = "recipe_id"

        fun create(recipeId: Int) = RecipeInfoListFragment().also {
            val args = bundleOf(
                PARAM_RECIPE_DATA to recipeId
            )
            it.arguments = args
        }
    }

}