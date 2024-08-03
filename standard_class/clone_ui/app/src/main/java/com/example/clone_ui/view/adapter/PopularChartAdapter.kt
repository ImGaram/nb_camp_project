package com.example.clone_ui.view.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.clone_ui.R
import com.example.clone_ui.data.PopularAppData
import com.example.clone_ui.databinding.ItemMainPopularChartBinding

class PopularChartAdapter(private val context: Context): ListAdapter<PopularAppData, PopularChartAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<PopularAppData>() {
        override fun areItemsTheSame(oldItem: PopularAppData, newItem: PopularAppData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PopularAppData, newItem: PopularAppData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_popular_chart, parent, false)
        return ViewHolder(ItemMainPopularChartBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rankingApp = getItem(position)
        holder.bind(rankingApp)
    }

    inner class ViewHolder(private val binding: ItemMainPopularChartBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(app: PopularAppData) {
            with(binding) {
                popularItemRankText.text = app.rank.toString()
                popularItemAppIconImage.setImageResource(app.appIcon)
                popularItemAppTitleText.text = app.title
                popularItemAppCategoryText.text = app.category
                popularItemAppStarRatingText.text = "${app.starRating}★"
                popularItemAppEventText.text = app.event

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(app.link))
                    context.startActivity(intent)
                }
            }
        }
    }
}
