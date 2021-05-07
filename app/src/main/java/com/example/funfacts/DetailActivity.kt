package com.example.funfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funfacts.FactAdapter.Companion.FACT_EXTRA
import com.example.funfacts.FactAdapter.Companion.LOGO_EXTRA
import com.example.funfacts.FactAdapter.Companion.NAME_EXTRA
import com.example.funfacts.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private var binding : ActivityDetailBinding? = null
    var logo = 0
    var name = ""
    var detail = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        logo = intent.getIntExtra(LOGO_EXTRA, 0)
        name = intent.getStringExtra(NAME_EXTRA).toString()
        detail = intent.getStringExtra(FACT_EXTRA).toString()

        setUpFactDetails()
    }

    private fun setUpFactDetails(){
        binding?.logo?.setImageResource(logo)
        binding?.description?.text = detail
        title = name
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}