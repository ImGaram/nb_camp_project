package com.example.clone_ui.adapter.recommend

import android.content.Context
import android.content.Intent
import android.icu.text.DecimalFormat
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.data.recommend.PremiumAppData
import com.example.clone_ui.databinding.ItemRecommendPremiumAppBinding

class RecommendPremiumAdapter(private val context: Context): ListAdapter<PremiumAppData, RecommendPremiumAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<PremiumAppData>() {
        override fun areItemsTheSame(oldItem: PremiumAppData, newItem: PremiumAppData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PremiumAppData, newItem: PremiumAppData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recommend_premium_app, parent, false)
        return ViewHolder(ItemRecommendPremiumAppBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemRecommendPremiumAppBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PremiumAppData) {
            with(binding) {
                val priceFormat = DecimalFormat("#,###₩")

                premiumItemAppIcon.setImageResource(data.appIcon)
                premiumItemAppTitle.text = data.title
                premiumItemDescription.text = data.description
                premiumItemStarRate.text = "${data.starRating}★"
                premiumItemPrice.text = priceFormat.format(data.price)

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(data.link))
                    context.startActivity(intent)
                }
            }
        }
    }
}