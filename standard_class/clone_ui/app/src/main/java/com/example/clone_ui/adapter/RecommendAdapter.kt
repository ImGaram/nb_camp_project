package com.example.clone_ui.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.adapter.recommend.RecommendPremiumAdapter
import com.example.clone_ui.adapter.recommend.RecommendSponsorAdapter
import com.example.clone_ui.data.RecommendData
import com.example.clone_ui.databinding.ItemRecommendAppsListBinding
import com.example.clone_ui.databinding.ItemRecommendEventAppBinding
import com.example.clone_ui.databinding.ItemRecommendHeaderBinding

class RecommendAdapter(private val context: Context): ListAdapter<RecommendData, RecyclerView.ViewHolder>(
    object: DiffUtil.ItemCallback<RecommendData>() {
        override fun areItemsTheSame(oldItem: RecommendData, newItem: RecommendData): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: RecommendData, newItem: RecommendData): Boolean = oldItem == newItem
    }
) {
    companion object {
        private const val TYPE_HEADER = 1
        private const val TYPE_EVENT = 2
        private const val TYPE_APPS_SPONSOR = 3
        private const val TYPE_APPS_PREMIUM = 4
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RecommendData.HeaderData -> TYPE_HEADER
            is RecommendData.EventAppData -> TYPE_EVENT
            is RecommendData.SponsorAppDataList -> TYPE_APPS_SPONSOR
            is RecommendData.PremiumAppDataList -> TYPE_APPS_PREMIUM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_header, parent, false)
                HeaderViewHolder(ItemRecommendHeaderBinding.bind(view))
            }
            TYPE_EVENT -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_event_app, parent, false)
                EventViewHolder(ItemRecommendEventAppBinding.bind(view))
            }
            TYPE_APPS_SPONSOR -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_apps_list, parent, false)
                SponsorAppViewHolder(ItemRecommendAppsListBinding.bind(view))
            }
            else -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_apps_list, parent, false)
                PremiumAppViewHolder(ItemRecommendAppsListBinding.bind(view))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = getItem(position)) {
            is RecommendData.HeaderData -> (holder as HeaderViewHolder).bind(item)
            is RecommendData.EventAppData -> (holder as EventViewHolder).bind(item)
            is RecommendData.SponsorAppDataList -> (holder as SponsorAppViewHolder).bind(item)
            is RecommendData.PremiumAppDataList -> (holder as PremiumAppViewHolder).bind(item)
        }
    }

    inner class HeaderViewHolder(private val binding: ItemRecommendHeaderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendData.HeaderData) {
            binding.recommendHeaderTitle.text = item.headerTitle
        }
    }

    inner class EventViewHolder(private val binding: ItemRecommendEventAppBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RecommendData.EventAppData) {
            with(binding) {
                eventItemBannerImage.setImageResource(item.banner)
                eventItemAppIcon.setImageResource(item.appIcon)
                eventItemAppTitle.text = item.title
                eventItemCategory.text = item.category
                eventItemStarRate.text = "${item.starRating}★"
                eventItemMoreData.text = item.more

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.link))
                    context.startActivity(intent)
                }
            }
        }
    }

    inner class SponsorAppViewHolder(private val binding: ItemRecommendAppsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(list: RecommendData.SponsorAppDataList) {
            val adapter = RecommendSponsorAdapter(context)
            val recyclerView = binding.recommendAppListRecyclerView
            val pagerSnapHelper = PagerSnapHelper()

            adapter.submitList(list.list)
            pagerSnapHelper.attachToRecyclerView(recyclerView)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false)
        }
    }

    inner class PremiumAppViewHolder(private val binding: ItemRecommendAppsListBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(list: RecommendData.PremiumAppDataList) {
            val adapter = RecommendPremiumAdapter(context)
            val recyclerView = binding.recommendAppListRecyclerView
            val pagerSnapHelper = PagerSnapHelper()

            adapter.submitList(list.list)
            pagerSnapHelper.attachToRecyclerView(recyclerView)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = GridLayoutManager(context, 3, GridLayoutManager.HORIZONTAL, false)
        }
    }
}