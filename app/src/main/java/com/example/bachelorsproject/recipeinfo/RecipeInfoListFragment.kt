package com.example.bachelorsproject.recipeinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bachelorsproject.R
import com.example.bachelorsproject.model.RecipeInfo
import com.example.bachelorsproject.provider.RecipeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class RecipeInfoListFragment: Fragment() {

    private val scopeRecipeInfo = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private val viewRecipeInfoModel by viewModel<RecipeInfoViewModel>()

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

        viewRecipeInfoModel.loadRecipeInfoAndComponents(recipeId)

        scopeRecipeInfo.launch {
            viewRecipeInfoModel.getRecipeInfoLiveData.observe(viewLifecycleOwner, { recipeInfo ->
                if (recipeInfo != null){
                    bindUI(view,recipeInfo)
                }
            })
        }

        view.findViewById<Button>(R.id.btnAdd).setOnClickListener {
            Toast.makeText(context, "You just added this dish to your order", Toast.LENGTH_SHORT).show()
        }
    }

    private fun bindUI(view: View, recipe: RecipeInfo){
        updateRecipeInfo(recipe)
        val adapter = view.findViewById<RecyclerView>(R.id.recycler_ingredients).adapter as RecipeInfoAdapter
        adapter.submitList(recipe.components)
    }

    private fun updateRecipeInfo(recipe: RecipeInfo){
        val price = view?.findViewById<TextView>(R.id.tvPrice)

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
        if (context != null){
            price?.text = context.getString(R.string.price_d_uah, recipe.pricePerServing)
        }
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