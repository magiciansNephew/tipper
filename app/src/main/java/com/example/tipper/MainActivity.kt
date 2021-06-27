package com.example.tipper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipper.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcButton.setOnClickListener { displayTip(calculateTip()) }
    }

    private fun calculateTip(): Double {
        var totalPrice = binding.plainTextInput.text.toString().toDoubleOrNull()
        var tipPercentage = when (binding.tipOptions.checkedRadioButtonId) {
            R.id.option_fifteen_percent  -> 0.15
            R.id.option_eighteen_percent -> 0.18
            else   -> 0.20
        }
        var tipAmount: Double

        tipAmount = if (totalPrice != null) {
            totalPrice * tipPercentage
        }else{
            0.0
        }

        if(binding.roundUpSwitch.isChecked){
            tipAmount = kotlin.math.ceil(tipAmount)
        }

        return tipAmount
    }

    private fun displayTip(tip: Double){
        var formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipAmount.text = getString(R.string.tip_amount, formattedTip)
    }
}