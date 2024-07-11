package com.example.applemarket.adapter

import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.R
import com.example.applemarket.data.GoodsData
import com.example.applemarket.data.GoodsObject
import com.example.applemarket.databinding.ItemRecyclerViewGoodsBinding

class GoodsAdapter: RecyclerView.Adapter<GoodsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_goods, parent, false)
        return ViewHolder(ItemRecyclerViewGoodsBinding.bind(binding))
    }

    override fun getItemCount(): Int = GoodsObject.goodsList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val goods = GoodsObject.goodsList[position]
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
                    // todo :: 데이터 클릭 이벤트(intent).
                }
            }
        }
    }
}