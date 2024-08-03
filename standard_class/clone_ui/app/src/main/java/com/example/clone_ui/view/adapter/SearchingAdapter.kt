package com.example.clone_ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.data.SearchHistoryData
import com.example.clone_ui.databinding.ItemSearchHistoryBinding

class SearchingAdapter(private val onPasteClick: (String) -> Unit): ListAdapter<SearchHistoryData, SearchingAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<SearchHistoryData>() {
        override fun areItemsTheSame(oldItem: SearchHistoryData, newItem: SearchHistoryData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: SearchHistoryData, newItem: SearchHistoryData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_history, parent, false)
        return ViewHolder(ItemSearchHistoryBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemSearchHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SearchHistoryData) {
            binding.itemHistoryText.text = item.searchText
            binding.itemHistoryPasteImage.setOnClickListener {
                onPasteClick(item.searchText)
            }
        }
    }
}
