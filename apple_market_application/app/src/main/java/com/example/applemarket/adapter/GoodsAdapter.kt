package com.example.applemarket.adapter

import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.R
import com.example.applemarket.data.GoodsData
import com.example.applemarket.databinding.ItemRecyclerViewGoodsBinding

class GoodsAdapter(
    private val onItemClick: (GoodsData) -> Unit,
    private val onLongItemClick: (Int) -> Unit
): ListAdapter<GoodsData, GoodsAdapter.ViewHolder>(
    object: DiffUtil.ItemCallback<GoodsData>() {
        override fun areItemsTheSame(oldItem: GoodsData, newItem: GoodsData): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: GoodsData, newItem: GoodsData): Boolean = oldItem == newItem
    }
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_goods, parent, false)
        return ViewHolder(ItemRecyclerViewGoodsBinding.bind(binding))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goods = getItem(position)
        holder.bind(goods)
    }

    inner class ViewHolder(private val binding: ItemRecyclerViewGoodsBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(goods: GoodsData) {
            with(binding) {
                val priceFormat = DecimalFormat("#,###원")

                goodsImage.setImageResource(goods.goodsImage)
                goodsTitle.text = goods.title
                goodsAddress.text = goods.address
                goodsPrice.text = priceFormat.format(goods.price)
                goodsChatCnt.text = goods.chatCnt.toString()
                goodsLikeCnt.text = goods.likeCnt.toString()

                goodsLikeStatusImage.setOnClickListener {
                    // todo :: 좋아요 클릭 이벤트.
                }

                binding.root.setOnClickListener {
                    onItemClick(goods)
                }

                binding.root.setOnLongClickListener {
                    val newList = currentList.toMutableList()
                    newList.removeIf { it.id == goods.id }
                    updateList(newList)

                    return@setOnLongClickListener true
                }
            }
        }
    }

    private fun updateList(newList: List<GoodsData>) {
        submitList(newList)
    }
}