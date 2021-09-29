package com.example.tippernewnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.slider.Slider
import com.google.android.material.textfield.TextInputEditText
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

//    rangeSlider.setLabelFormatter { value: Float ->
//        val format = NumberFormat.getCurrencyInstance()
//        format.maximumFractionDigits = 0
//        format.currency = Currency.getInstance("USD")
//        format.format(value.toDouble())
//    }

    private lateinit var tipSliderView: Slider
    private lateinit var baseAmountView : TextInputEditText
    private lateinit var tipAmountView : TextView
    private lateinit var totalAmountView : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tipSliderView = findViewById(R.id.tipSlider)
        baseAmountView = findViewById(R.id.baseAmount)
        tipAmountView = findViewById(R.id.tipAmount)
        totalAmountView = findViewById(R.id.totalAmountView)
        updateTipValues()

        tipSliderView.addOnChangeListener { slider, value, fromUser ->
            updateTipValues()
        }
        baseAmountView.doAfterTextChanged{updateTipValues()}

    }
    private fun updateTipValues (){
        val baseAmountValue = baseAmountView.text.toString().toFloat()
        val tipPercent = tipSliderView.value
        val tipValue =  baseAmountValue * tipPercent / 100
        val totalAmount  = baseAmountValue + tipValue
        tipAmountView.text = tipValue.toString()
        totalAmountView.text = totalAmount.toString()
    }
}