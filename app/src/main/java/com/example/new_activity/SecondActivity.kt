package com.example.new_activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log

class SecondActivity : AppCompatActivity() {

    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val userInfoTextView: TextView = findViewById(R.id.userInfo)
        val detailsButton: Button = findViewById(R.id.detailsButton)

        val firstName = intent.getStringExtra("firstName")
        val lastName = intent.getStringExtra("lastName")
        val email = intent.getStringExtra("email")

        userInfoTextView.text = "Вітаю! $firstName $lastName\n"

        detailsButton.setOnClickListener {
            val intent = Intent(this, UserDetailsActivity::class.java).apply {
                putExtra("firstName", firstName)
                putExtra("lastName", lastName)
                putExtra("email", email)
            }
            startActivity(intent)
            Log.d(TAG, "SecondActivity() was called")
            Toast.makeText(this, "UserDetailsActivity() викликано", Toast.LENGTH_SHORT).show()
        }
    }
}