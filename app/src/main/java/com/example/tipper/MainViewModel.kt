package com.example.tipper

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private var _tipAmount: Double = 0.0
    val tipAmount: Double
        get() = _tipAmount

    fun calculateTip(totalPrice: Double?, tipPercentage: Double, roundUp: Boolean): Double {

        _tipAmount = if (totalPrice != null) {
            totalPrice * tipPercentage
        }else{
            0.0
        }

        if(roundUp){
            _tipAmount = kotlin.math.ceil(tipAmount)
        }

        return tipAmount
    }
}