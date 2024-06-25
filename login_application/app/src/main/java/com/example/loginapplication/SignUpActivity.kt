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
import com.example.loginapplication.data.User

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val signUpNameEditText = findViewById<EditText>(R.id.edit_text_sign_up_name)
        val signUpIdEditText = findViewById<EditText>(R.id.edit_text_sign_up_id)
        val signUpPwEditText = findViewById<EditText>(R.id.edit_text_sign_up_pw)
        val signUpCompleteButton = findViewById<Button>(R.id.button_sign_up_completed)

        signUpCompleteButton.setOnClickListener {
            if (signUpNameEditText.text.isNotEmpty() && signUpIdEditText.text.isNotEmpty() && signUpPwEditText.text.isNotEmpty()) {
                val intent = Intent(this, SignInActivity::class.java)
                val user = User(signUpNameEditText.text.toString(), signUpIdEditText.text.toString(), signUpPwEditText.text.toString())
                intent.putExtra("user", user)
                setResult(RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }
}