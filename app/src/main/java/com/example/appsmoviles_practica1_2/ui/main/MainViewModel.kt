package com.example.appsmoviles_practica1_2.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val cop_conv = floatArrayOf(1f, 0.00026f, 0.00025f)
    private val usd_conv = floatArrayOf(3781f, 1f, 0.93f)
    private val eur_conv = floatArrayOf(4053f, 1.07f, 1f)
    private var factConv = floatArrayOf(0f,0f,0f)
    private var convert_result : MutableLiveData<Float> = MutableLiveData()
    val convert_resultDone: LiveData<Float> = convert_result

  fun currency_conversion(currencyfrom: Int, currencyto: Int, amount: Int){
        when(currencyfrom){
            0 -> factConv = cop_conv.copyOf()
            1 -> factConv = usd_conv.copyOf()
            2 -> factConv = eur_conv.copyOf()
            else ->{
                factConv = floatArrayOf(0f,0f,0f)
            }
        }
        convert_result.value = amount * factConv.get(currencyto)
    }
}