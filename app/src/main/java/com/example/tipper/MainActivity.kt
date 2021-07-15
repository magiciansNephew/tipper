package com.example.tipper

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tipper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this
        binding.calcButton.setOnClickListener { calculate() }
        viewModel.formatTipAmount()
    }

    private fun calculate() {
        var totalPrice = binding.costOfServiceEditText.text.toString().toDoubleOrNull()
        var tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_fifteen_percent -> 0.15
            R.id.option_eighteen_percent -> 0.18
            else -> 0.20
        }
        var roundUp = binding.roundUpSwitch.isChecked

        viewModel.calculateTip(totalPrice, tipPercentage, roundUp)
    }
}