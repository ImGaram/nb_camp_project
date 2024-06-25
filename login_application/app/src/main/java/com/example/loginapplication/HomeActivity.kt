package com.example.loginapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val extraId = intent.getStringExtra("id")
        val homeTextIdValue = findViewById<TextView>(R.id.text_home_id_value)
        if (extraId != null) homeTextIdValue.text = extraId

        val finishButton = findViewById<ConstraintLayout>(R.id.button_home_finish)
        finishButton.setOnClickListener { finish() }

        val homeTitleImage = findViewById<ImageView>(R.id.image_home_title)
        val random = Random().nextInt(5)
        when (random) {
            0 -> homeTitleImage.setImageResource(R.drawable.image_title_home1)
            1 -> homeTitleImage.setImageResource(R.drawable.image_title_home2)
            2 -> homeTitleImage.setImageResource(R.drawable.image_title_home3)
            3 -> homeTitleImage.setImageResource(R.drawable.image_title_home4)
            4 -> homeTitleImage.setImageResource(R.drawable.image_title_home5)
        }
    }
}