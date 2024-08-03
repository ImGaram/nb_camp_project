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
import com.example.clone_ui.data.PopularChartData
import com.example.clone_ui.databinding.ItemMainPopularChartBinding

class PopularChartAdapter(private val context: Context): ListAdapter<PopularChartData, PopularChartAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<PopularChartData>() {
        override fun areItemsTheSame(oldItem: PopularChartData, newItem: PopularChartData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: PopularChartData, newItem: PopularChartData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_main_popular_chart, parent, false)
        return ViewHolder(ItemMainPopularChartBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val chartData = getItem(position)
        holder.bind(chartData)
    }

    inner class ViewHolder(private val binding: ItemMainPopularChartBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(chartData: PopularChartData) {
            with(binding) {
                popularItemRankText.text = chartData.rank.toString()
                popularItemAppIconImage.setImageResource(chartData.appIcon)
                popularItemAppTitleText.text = chartData.title
                popularItemAppCategoryText.text = chartData.category
                popularItemAppStarRatingText.text = "${chartData.starRating}★"
                popularItemAppEventText.text = chartData.event

                root.setOnClickListener {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(chartData.link))
                    context.startActivity(intent)
                }
            }
        }
    }
}
