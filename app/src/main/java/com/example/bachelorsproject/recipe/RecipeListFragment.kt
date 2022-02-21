package com.example.bachelorsproject.recipe

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bachelorsproject.R
import com.example.bachelorsproject.data.local.sharedpreferences.SharedPref
import com.example.bachelorsproject.model.Recipe
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipeListFragment: Fragment() {


//    private val viewRecipeModel: RecipeViewModel by viewModels{
//        RecipeViewModelFactory((requireActivity() as RecipeProvider).provideRecipe())
//    }

    private val viewRecipeModel by viewModel<RecipeViewModel>()

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
    ): View{
        super.onCreateView(inflater, container, savedInstanceState)
        val v = inflater.inflate(R.layout.fragment_recipe_list,container,false)

        val shared = SharedPref(requireActivity().application)
        if (shared.isFirst){
            showDialog()
            shared.isFirst = false
        }


        return v
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val edit = view.findViewById<EditText>(R.id.etForRecipe)
        val button = view.findViewById<Button>(R.id.btnClick)

        view.findViewById<RecyclerView>(R.id.recycler_recipe).apply {

            this.layoutManager = GridLayoutManager(context, 2)

            val adapter = RecipeListAdapter{ recipeId ->
                listener?.onRecipeSelected(recipeId)
            }

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

    private fun showDialog(){

        val builder = AlertDialog.Builder(context)
        val inflater = layoutInflater
        builder.setTitle("With EditText")
        val dialogLayout = inflater.inflate(R.layout.layout_for_dialog, null)
        val etLogin  = dialogLayout.findViewById<EditText>(R.id.etLogin)
        val etPassword  = dialogLayout.findViewById<EditText>(R.id.etPassword)
        builder.setView(dialogLayout)
        builder.setPositiveButton("OK") { dialogInterface, i ->
            Toast.makeText(context, "Welcome back " + etLogin.text.toString(), Toast.LENGTH_SHORT).show() }
        builder.show()

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