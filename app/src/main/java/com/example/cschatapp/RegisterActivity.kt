package com.example.cschatapp

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonRegister = findViewById<Button>(R.id.buttonRegister)
        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)

        buttonRegister.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()
            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("username", username)
            editor.putString("password", password)
            editor.apply()

            Log.d("RegisterActivity", "Username: $username, Password: $password") // Log
            Toast.makeText(this, "Register Berhasil", Toast.LENGTH_SHORT).show() // Toast
            Toast.makeText(this, "Selamat datang, $username", Toast.LENGTH_LONG).show() // Toast
        }
    }
}
