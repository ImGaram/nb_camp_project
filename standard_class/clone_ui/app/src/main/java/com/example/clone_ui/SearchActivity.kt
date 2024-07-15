package com.example.clone_ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo.IME_ACTION_SEARCH
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clone_ui.data.LinkObject

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val searchEditText = findViewById<EditText>(R.id.search_edit_app)
        val searchResult = findViewById<ScrollView>(R.id.search_layout_search_result)
        val backBtn = findViewById<ImageView>(R.id.search_image_back)

        searchEditText.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) searchResult.visibility = View.GONE
        }

        searchEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == IME_ACTION_SEARCH) {
                // 입력이 완료되면 키보드를 내리기.
                val manager: InputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                manager.hideSoftInputFromWindow(searchEditText.windowToken, 0)

                if (searchEditText.text.isNotEmpty()) searchResult.visibility = View.VISIBLE
                else searchResult.visibility = View.GONE

                // 포커싱 해제.
                searchEditText.clearFocus()
            }
            true
        }

        backBtn.setOnClickListener { finish() }

        // 앱 클릭 리스너.
        val sponsor = listOf(
            R.id.search_sponsor_1, R.id.search_sponsor_2, R.id.search_sponsor_3,
            R.id.search_sponsor_4, R.id.search_sponsor_5, R.id.search_sponsor_6,
            R.id.search_sponsor_7, R.id.search_sponsor_8, R.id.search_sponsor_9,
        )
        val popular = listOf(
            R.id.search_popular_1, R.id.search_popular_2, R.id.search_popular_3,
            R.id.search_popular_4, R.id.search_popular_5, R.id.search_popular_6,
            R.id.search_popular_7, R.id.search_popular_8, R.id.search_popular_9,
            R.id.search_popular_10,
        )
        for (i in sponsor.indices) {
            val sponsorApp = findViewById<LinearLayout>(sponsor[i])
            sponsorApp.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(LinkObject.sponsorLink[i]))
                startActivity(intent)
            }
        }
        for (i in popular.indices) {
            val popularApp = findViewById<LinearLayout>(popular[i])
            popularApp.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(LinkObject.rankingLink[i]))
                startActivity(intent)
            }
        }
    }
}