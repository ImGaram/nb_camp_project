package com.example.loginapplication

import android.os.Build
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginapplication.data.User
import java.util.Random

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
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

        val extraUser = intent.getParcelableExtra("userData", User::class.java)
        val homeTextIdValue = findViewById<TextView>(R.id.text_home_id_value)
        val homeTextNameValue = findViewById<TextView>(R.id.text_home_name_value)

        if (extraUser?.id != null) homeTextIdValue.text = extraUser.id
        if (extraUser?.name != null) homeTextNameValue.text = extraUser.name

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