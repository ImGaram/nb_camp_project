package com.example.clone_ui.adapter

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.adapter.search.CategoryAdapter
import com.example.clone_ui.data.SearchData
import com.example.clone_ui.databinding.ItemSearchAppsListBinding
import com.example.clone_ui.databinding.ItemSearchHeaderBinding
import com.example.clone_ui.databinding.ItemSearchSponsorAppBinding

class SearchAdapter(private val context: Context, private val onCategoryCardClick: (String) -> Unit): ListAdapter<SearchData, RecyclerView.ViewHolder>(
    object: DiffUtil.ItemCallback<SearchData>() {
        override fun areItemsTheSame(oldItem: SearchData, newItem: SearchData): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: SearchData, newItem: SearchData): Boolean = oldItem == newItem
    }
) {
    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_CATEGORY_GAME = 2
        private const val TYPE_CATEGORY_APPS = 3
        private const val TYPE_SPONSOR = 4
        private val RECYCLERVIEW_DECO_SPACING_ITEM = object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                val pos = parent.getChildAdapterPosition(view)
                val column = pos % 2 + 1

                if (pos >= 2) outRect.top = 24
                if (column != 1) outRect.left = 24
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is SearchData.SearchHeaderData -> TYPE_HEADER
            is SearchData.GameCategoryData -> TYPE_CATEGORY_GAME
            is SearchData.AppCategoryData -> TYPE_CATEGORY_APPS
            is SearchData.SearchSponsorAppData -> TYPE_SPONSOR
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_header, parent, false)
                SearchHeaderViewHolder(ItemSearchHeaderBinding.bind(view))
            }
            TYPE_CATEGORY_GAME -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_apps_list, parent, false)
                SearchGameCategoryListViewHolder(ItemSearchAppsListBinding.bind(view))
            }
            TYPE_CATEGORY_APPS -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_apps_list, parent, false)
                SearchAppsCategoryListViewHolder(ItemSearchAppsListBinding.bind(view))
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_sponsor_app, parent, false)
                SearchSponsorViewHolder(ItemSearchSponsorAppBinding.bind(view))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is SearchData.SearchHeaderData -> (holder as SearchHeaderViewHolder).bind(item)
            is SearchData.GameCategoryData -> (holder as SearchGameCategoryListViewHolder).bind(item)
            is SearchData.AppCategoryData -> (holder as SearchAppsCategoryListViewHolder).bind(item)
            is SearchData.SearchSponsorAppData -> (holder as SearchSponsorViewHolder).bind(item)
        }
    }

    inner class SearchHeaderViewHolder(private val binding: ItemSearchHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchData.SearchHeaderData) {
            binding.itemSearchHeaderTitle.text = data.title
        }
    }

    inner class SearchGameCategoryListViewHolder(private val binding: ItemSearchAppsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchData.GameCategoryData) {
            val recyclerView = binding.itemSearchAppListRecyclerView
            val adapter = CategoryAdapter { onCategoryCardClick("$it 게임") }

            adapter.submitList(data.list)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            recyclerView.addItemDecoration(RECYCLERVIEW_DECO_SPACING_ITEM)
        }
    }

    inner class SearchAppsCategoryListViewHolder(private val binding: ItemSearchAppsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchData.AppCategoryData) {
            val recyclerView = binding.itemSearchAppListRecyclerView
            val adapter = CategoryAdapter(onCategoryCardClick)

            adapter.submitList(data.list)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(context, 2)
            recyclerView.addItemDecoration(RECYCLERVIEW_DECO_SPACING_ITEM)
        }
    }

    inner class SearchSponsorViewHolder(private val binding: ItemSearchSponsorAppBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SearchData.SearchSponsorAppData) {
            with(binding) {
                itemSearchSponsorAppIcon.setImageResource(data.appIcon)
                itemSearchSponsorAppTitle.text = data.title
                itemSearchSponsorCategory.text = data.category
                itemSearchSponsorStarRate.text = "${data.starRating}★"
                itemSearchSponsorDownloadCnt.text = data.downLoads

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
                    context.startActivity(intent)
                }
            }
        }
    }
}