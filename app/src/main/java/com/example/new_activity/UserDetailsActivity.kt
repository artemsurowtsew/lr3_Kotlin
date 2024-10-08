package com.example.new_activity

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UserDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        val userDetailsTextView: TextView = findViewById(R.id.userDetails)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")

        userDetailsTextView.text = "Ім'я: $firstName\nПрізвище: $lastName\nEmail: $email"
        Log.d("UserDetailsActivity", "UserDetailsActivity() was called")
        Toast.makeText(this, "UserDetailsActivity() викликано", Toast.LENGTH_SHORT).show()
    }
}