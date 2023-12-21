package com.example.disney

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.title = "tp f2i"

        val googleImageCard = findViewById<CardView>(R.id.cardViewGoogle)
        val facebookImageCard = findViewById<CardView>(R.id.cardViewFacebook)
        val appleImageCard = findViewById<CardView>(R.id.cardViewApple)

        googleImageCard.setOnClickListener {
            Toast.makeText(this@MainActivity, "Connected with Google", Toast.LENGTH_SHORT).show()
            navigate()
        }

        facebookImageCard.setOnClickListener {
            Toast.makeText(this@MainActivity, "Connected with Facebook", Toast.LENGTH_SHORT).show()
            navigate()
        }

        appleImageCard.setOnClickListener {
            Toast.makeText(this@MainActivity, "Connected with Apple ID", Toast.LENGTH_SHORT).show()
            navigate()
        }

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                Toast.makeText(this@MainActivity, "Login successful", Toast.LENGTH_SHORT).show()
                navigate()
            } else {
                Toast.makeText(this@MainActivity, "Please enter email and password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigate() {
        val intent = Intent(this@MainActivity, HomeActivity::class.java)
        startActivity(intent)
    }
}
