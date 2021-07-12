package com.example.tipper

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private val _tipAmount = MutableLiveData<Double>(0.0)
    val tipAmount: LiveData<Double>
        get() = _tipAmount

    fun calculateTip(totalPrice: Double?, tipPercentage: Double, roundUp: Boolean) {

        _tipAmount.value = if (totalPrice != null) {
            totalPrice * tipPercentage
        }else{
            0.0
        }

        if(roundUp){
            _tipAmount.value = tipAmount.value?.let { kotlin.math.ceil(it) }
        }
    }
}