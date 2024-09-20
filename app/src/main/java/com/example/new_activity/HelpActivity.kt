package com.example.new_activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast

class HelpActivity : AppCompatActivity() {

    private val TAG = "HelpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val helpText: TextView = findViewById(R.id.helpText)
        Log.d(TAG, "HelpActivity() was called")
        Toast.makeText(this, "HelpActivity() викликано", Toast.LENGTH_SHORT).show()
        helpText.text = "Інструкція: Введіть свої дані, скоригуйте їх, якщо вони невірні та натисніть кнопку ||Надіслати||, після цього можете переглянути свої дані натиснувши кнопку ||Детальніше|| ."
    }
}