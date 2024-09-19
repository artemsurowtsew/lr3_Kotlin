package com.example.new_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class HelpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_help)

        val helpText: TextView = findViewById(R.id.helpText)
        helpText.text = "Цей додаток дозволяє вводити ім'я, прізвище та email, а потім переглядати введену інформацію."
    }
}