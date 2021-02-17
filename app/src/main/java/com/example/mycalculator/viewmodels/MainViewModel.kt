package com.example.mycalculator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {

    var expression: MutableLiveData<String> = MutableLiveData()

    fun setNumberToExpression(number: String) {
        expression.value = number
    }
}
