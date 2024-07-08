package com.example.clone_ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val searchBar = findViewById<ConstraintLayout>(R.id.main_layout_search_bar)
        searchBar.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        // 리스트 클릭 리스너
        val rank = listOf(
            R.id.main_popular_rank_1, R.id.main_popular_rank_2, R.id.main_popular_rank_3,
            R.id.main_popular_rank_4, R.id.main_popular_rank_5, R.id.main_popular_rank_6,
            R.id.main_popular_rank_7, R.id.main_popular_rank_8, R.id.main_popular_rank_9,
            R.id.main_popular_rank_10,
        )
        for (i in rank.indices) {
            val rankLay = findViewById<LinearLayout>(rank[i])
            rankLay.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(LinkObject.rankingLink[i]))
                startActivity(intent)
            }
        }
    }
}