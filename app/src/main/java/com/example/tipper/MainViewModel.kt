package com.example.tipper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.NumberFormat

class MainViewModel: ViewModel(){
    private val _tipAmount = MutableLiveData(0.0)
    val tipAmount: LiveData<Double>
        get() = _tipAmount

    private val _formattedTipAmount = MutableLiveData<String>()
    val formattedTipAmount: LiveData<String>
        get() = _formattedTipAmount


    fun calculateTip(totalPrice: Double?, tipPercentage: Double, roundUp: Boolean) {

        _tipAmount.value = if (totalPrice != null) {
            totalPrice * tipPercentage
        }else{
            0.0
        }

        if(roundUp){
            _tipAmount.value = tipAmount.value?.let { kotlin.math.ceil(it) }
        }

        formatTipAmount()
    }

    fun formatTipAmount(){
        _formattedTipAmount.value = NumberFormat.getCurrencyInstance().format(tipAmount.value)
    }
}