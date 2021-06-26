package com.example.tipper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calculateTip() {
        binding.plainTextInput.text
    }
}