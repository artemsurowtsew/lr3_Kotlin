package com.example.new_activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.util.Log


class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    internal fun EditText.isEmailValid(): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(this.text.toString()).matches()
    }
    internal fun String.isNameValid(): Boolean {
        return this.all { it.isLetter() }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstNameEditText: EditText = findViewById(R.id.firstName)
        val lastNameEditText: EditText = findViewById(R.id.lastName)
        val emailEditText: EditText = findViewById(R.id.email)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val firstName = firstNameEditText.text.toString()
            val lastName = lastNameEditText.text.toString()
            val email = emailEditText.text.toString()

            if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Будь ласка, заповніть всі поля", Toast.LENGTH_SHORT).show()
            }
            else if (!emailEditText.isEmailValid()) {
                Toast.makeText(this, "Будь ласка, введіть правильну адресу електронної пошти", Toast.LENGTH_SHORT).show()
            }
            else if (!firstName.isNameValid() || !lastName.isNameValid())
            {
                Toast.makeText(this, "Ім'я та прізвище повинні містити лише літери", Toast.LENGTH_SHORT).show()
            }
            else {
                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("firstName", firstName)
                    putExtra("lastName", lastName)
                    putExtra("email", email)
                }
                startActivity(intent)

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        Toast.makeText(this, "onCreateOptionsMenu() was called", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "onCreateOptionsMenu() ")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.helpMenu -> {
                val intent = Intent(this, HelpActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "HelpActivity() викликано", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
