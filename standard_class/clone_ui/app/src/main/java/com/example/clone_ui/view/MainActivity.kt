package com.example.clone_ui.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.clone_ui.R
import com.example.clone_ui.data.`object`.PopularRankObject
import com.example.clone_ui.databinding.ActivityMainBinding
import com.example.clone_ui.view.fragment.AppsFragment
import com.example.clone_ui.view.fragment.BookFragment
import com.example.clone_ui.view.fragment.GameFragment
import com.example.clone_ui.view.fragment.SearchFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        if (PopularRankObject.getPopularRank().isEmpty()) PopularRankObject.initPopularRank()

        changeFragment(R.id.menu_game)
        binding.mainLayoutBottomNavigation.setOnItemSelectedListener { menu ->
            changeFragment(menu.itemId)
            true
        }
    }

    private fun changeFragment(itemId: Int) {
        when (itemId) {
            R.id.menu_game -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, GameFragment())
                    .commit()
            }
            R.id.menu_apps -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, AppsFragment())
                    .commit()
            }
            R.id.menu_search -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, SearchFragment())
                    .commit()
            }
            R.id.menu_books -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, BookFragment())
                    .commit()
            }
        }
    }
}