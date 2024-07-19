package com.example.clone_ui.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.data.search.CategoryData
import com.example.clone_ui.databinding.ItemSearchAppCategoriesBinding

class CategoryAdapter(private val onItemClick: (String) -> Unit): ListAdapter<CategoryData, CategoryAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<CategoryData>() {
        override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_app_categories, parent, false)
        return ViewHolder(ItemSearchAppCategoriesBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSearchAppCategoriesBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(category: CategoryData) {
            binding.itemSearchCategoryName.text = category.category
            binding.root.setOnClickListener { onItemClick(category.category) }
        }
    }
}
