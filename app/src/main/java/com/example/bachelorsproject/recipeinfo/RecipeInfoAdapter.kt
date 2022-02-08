package com.example.bachelorsproject.recipeinfo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bachelorsproject.R
import com.example.bachelorsproject.model.Component


class RecipeInfoAdapter: ListAdapter<Component, RecipeInfoAdapter.ViewHolder>(DiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_info_view_holder, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val imageOfComponent: ImageView = itemView.findViewById(R.id.ivInfoRecipe)
        private val titleOfComponent: TextView = itemView.findViewById(R.id.tvNameOfComponent)
        private val dosesOfComponent: TextView = itemView.findViewById(R.id.tvDoses)

        fun bind(component: Component){

            Glide.with(itemView).load(component.imageOfComponent).into(imageOfComponent)
            titleOfComponent.text = component.titleOfComponent
            dosesOfComponent.text = component.dosesOfComponent
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Component>() {
        override fun areItemsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem.componentId == newItem.componentId
        }

        override fun areContentsTheSame(oldItem: Component, newItem: Component): Boolean {
            return oldItem == newItem
        }
    }

}