package com.example.funfacts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.funfacts.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.loginButton?.setOnClickListener {
            if (binding?.email?.text.toString() == "email@email.com" && binding?.password?.text.toString() == "password") {
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }else{
                Toast.makeText(this, "Please Enter Email and password shown", Toast.LENGTH_SHORT).show()
            }
        }
    }
}