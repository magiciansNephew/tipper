package com.example.tipper

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcButton.setOnClickListener { calculate() }
        viewModel.tipAmount.observe(this, { newTipAmount ->
            binding.tipAmount.text = getString(
                R.string.tip_amount,
                NumberFormat.getCurrencyInstance().format(newTipAmount)
            )
        })
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