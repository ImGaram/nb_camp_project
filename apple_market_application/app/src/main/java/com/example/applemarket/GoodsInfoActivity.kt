package com.example.applemarket

import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applemarket.data.GoodsData
import com.example.applemarket.databinding.ActivityGoodsInfoBinding

class GoodsInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGoodsInfoBinding

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityGoodsInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val goods = intent.getParcelableExtra("goods", GoodsData::class.java)

        binding.goodsInfoBackImage.setOnClickListener { finish() }

        if (goods != null) {
            val decimalFormat = DecimalFormat("#,###원")
            with(binding) {
                goodsInfoImage.setImageResource(goods.goodsImage)
                goodsInfoSellerName.text = goods.seller
                goodsInfoSellerAddress.text = goods.address
                goodsInfoGoodsTitle.text = goods.title
                goodsInfoGoodsDescription.text = goods.description
                goodsInfoGoodsPrice.text = decimalFormat.format(goods.price)
            }
        }
    }
}