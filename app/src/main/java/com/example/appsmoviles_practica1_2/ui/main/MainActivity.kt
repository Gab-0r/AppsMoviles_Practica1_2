package com.example.appsmoviles_practica1_2.ui.main

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.appsmoviles_practica1_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        mainViewModel.convert_resultDone.observe(this){
            mainBinding.textViewCurrencyTo.text = it.toString()
        }

        with(mainBinding){
            convertButton.setOnClickListener{
                mainViewModel.currency_conversion(spCurrencyFrom.selectedItemPosition, spCurrencyTo.selectedItemPosition, TextInputEditTextCurrencyFrom.text.toString().toInt())
            }
        }
    }
}