package com.olgunbingol.makeupapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.olgunbingol.makeupapp.databinding.ActivityAnamenuBinding
import com.olgunbingol.makeupapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityAnamenuBinding

class AnamenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anamenu)
        binding = ActivityAnamenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun startClicked(view: View) {
        val intent = Intent(this@AnamenuActivity,MainActivity::class.java)
        startActivity(intent)
    }
}