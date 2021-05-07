package com.example.funfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.funfacts.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    var binding : ActivityListBinding? = null
    var adapter : FactAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setUpFactAdapter()
    }

    private fun setUpFactAdapter(){
        adapter = FactAdapter(this, DummyData.facts)
        binding?.factLv?.adapter = adapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}