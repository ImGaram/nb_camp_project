package com.example.clone_ui.view.adapter.recommend

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.data.recommend.SponsorAppData
import com.example.clone_ui.databinding.ItemRecommendSponsorAppBinding

class RecommendSponsorAdapter(private val context: Context): ListAdapter<SponsorAppData, RecommendSponsorAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<SponsorAppData>() {
        override fun areItemsTheSame(oldItem: SponsorAppData, newItem: SponsorAppData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: SponsorAppData, newItem: SponsorAppData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_sponsor_app, parent, false)
        return ViewHolder(ItemRecommendSponsorAppBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRecommendSponsorAppBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: SponsorAppData) {
            with(binding) {
                sponsorItemAppIcon.setImageResource(data.appIcon)
                sponsorItemAppTitle.text = data.title
                sponsorItemCategory.text = data.category
                sponsorItemStarRate.text = "${data.starRating}★"

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
                    context.startActivity(intent)
                }
            }
        }
    }
}