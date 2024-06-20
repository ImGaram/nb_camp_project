package com.example.loginapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val idEditText = findViewById<EditText>(R.id.edit_text_id)
        val pwEditText = findViewById<EditText>(R.id.edit_text_pw)
        val loginButton = findViewById<Button>(R.id.button_login)
        val signUpButton = findViewById<Button>(R.id.button_sign_up)

        loginButton.setOnClickListener {
            // id, pw 중 하나라도 비어 있으면 작동.
            if (idEditText.text.isNotBlank() && pwEditText.text.isNotBlank()) {
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", idEditText.text.toString())
                startActivity(intent)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        signUpButton.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}