package com.example.bachelorsproject.recipe

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bachelorsproject.R
import com.example.bachelorsproject.model.Recipe
import com.example.bachelorsproject.model.TotalResults
import com.example.bachelorsproject.provider.RecipeProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class RecipeListFragment: Fragment() {


    private val viewRecipeModel: RecipeViewModel by viewModels{
        RecipeViewModelFactory((requireActivity() as RecipeProvider).provideRecipe())
    }

    private val scopeRecipe = CoroutineScope(Dispatchers.Main + SupervisorJob())

    private var listener: RecipeListItemClickListener? = null

    override fun onAttach(context: Context) {
        if (context is RecipeListItemClickListener){
            listener = context
        }
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_recipe_list,container,false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val edit = view.findViewById<EditText>(R.id.etForRecipe)
        val button = view.findViewById<Button>(R.id.btnClick)

        view.findViewById<RecyclerView>(R.id.recycler_recipe).apply {

            this.layoutManager = GridLayoutManager(context, 2)

            val adapter = RecipeListAdapter()
            //TODO() Заміна
//            val adapter = RecipeListAdapter{ recipeId ->
//                listener?.onRecipeSelected(recipeId)
//            }

            this.adapter = adapter
        }

        button.setOnClickListener {
            val word = edit.text.toString()
            viewRecipeModel.loadRecipe(word)
        }
        scopeRecipe.launch {
            viewRecipeModel.getRecipeLiveData.observe(viewLifecycleOwner, { recipeImage ->
                if (recipeImage != null) {
                    bindUI(recipeImage)
                }
            })
        }


    }

    private fun bindUI(recipe: List<Recipe>){
        val adapter = view?.findViewById<RecyclerView>(R.id.recycler_recipe)?.adapter as RecipeListAdapter
        adapter.submitList(recipe)
    }

    override fun onDetach() {
        listener = null
        super.onDetach()
    }

    interface RecipeListItemClickListener {
        fun onRecipeSelected(recipeId: Int)
    }


    companion object{
        fun create() = RecipeListFragment()
    }
}