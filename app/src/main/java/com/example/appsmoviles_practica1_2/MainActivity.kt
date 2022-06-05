package com.example.appsmoviles_practica1_2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appsmoviles_practica1_2.databinding.ActivityMainBinding

class MainActivity : Activity() {
    //COP-USD-EUR
    val cop_conv = floatArrayOf(1f, 0.00026f, 0.00025f) //Arreglo de conversiones de COP a COP USD EUR
    val usd_conv = floatArrayOf(3781f, 1f, 0.93f) //Arreglo de conversiones de USD a COP USD EUR
    val eur_conv = floatArrayOf(4053f, 1.07f, 1f) //Arreglo de conversiones de EUR a COP USD EUR


    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)

        with(mainBinding){

            convertButton.setOnClickListener{
                var factConv = floatArrayOf(0f,0f,0f)
                var moneyAmount = TextInputEditTextCurrencyFrom.text.toString().toInt()
                var CurrencyFrom_ = spCurrencyFrom.selectedItemPosition //Selecciona la moneda a convertir
                var CurrencyTo_ = spCurrencyTo.selectedItemPosition //Selecciona la moneda a la cual se quiere llegar
                when(CurrencyFrom_){ //Se selecciona el vector de factores de conversion en base a la opción seleccionada
                    0 ->    factConv = cop_conv.copyOf()
                    1 ->    factConv = usd_conv.copyOf()
                    2 ->    factConv = eur_conv.copyOf()
                    else ->{
                        factConv = floatArrayOf(0f,0f,0f)
                    }
                }
                var convertResult = moneyAmount * factConv.get(CurrencyTo_)
                textViewCurrencyTo.text = convertResult.toString()
            }
        }
    }
}