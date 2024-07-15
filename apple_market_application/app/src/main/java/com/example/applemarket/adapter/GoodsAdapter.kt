package com.example.applemarket.adapter

import android.content.Context
import android.content.Intent
import android.icu.text.DecimalFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.applemarket.GoodsInfoActivity
import com.example.applemarket.R
import com.example.applemarket.data.GoodsData
import com.example.applemarket.databinding.ItemRecyclerViewGoodsBinding

class GoodsAdapter(private val context: Context): ListAdapter<GoodsData, GoodsAdapter.ViewHolder>(
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
                    val intent = Intent(context, GoodsInfoActivity::class.java)
                    intent.putExtra("goods", goods)
                    context.startActivity(intent)
                }

                binding.root.setOnLongClickListener {
                    AlertDialog.Builder(context)
                        .setIcon(R.drawable.ic_chatting)
                        .setTitle("상품 삭제")
                        .setMessage("상품을 정말로 삭제하시겠습니까?")
                        .setPositiveButton("확인") { dialog, _ ->
                            val newList = currentList.toMutableList()
                            newList.removeIf { it.id == goods.id }
                            updateList(newList)
                            dialog.dismiss()
                        }
                        .setNeutralButton("취소") { dialog, _ ->
                            dialog.dismiss()
                        }
                        .create()
                        .show()

                    return@setOnLongClickListener true
                }
            }
        }
    }

    private fun updateList(newList: List<GoodsData>) {
        submitList(newList)
    }
}