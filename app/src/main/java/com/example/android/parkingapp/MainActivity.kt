package com.example.android.parkingapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import java.text.DecimalFormat
import android.widget.Spinner
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var totalBill: Double = 0.00
    var inputPercent: Double = 0.00
    var outputTip: Double = 0.00
    var formatter: DecimalFormat = DecimalFormat("\u00A4###,###,###.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bill: EditText = findViewById(R.id.txtBill)
        val group: Spinner = findViewById(R.id.spnGroup)
        val calc: Button = findViewById(R.id.btnCalcTip)
        val result: TextView = findViewById(R.id.txtResult)

        calc.setOnClickListener{
            totalBill = bill.text.toString().toDouble()
            inputPercent = group.selectedItem.toString().replace("%","").toDouble()
            outputTip = totalBill * inputPercent / 100
            val outputTipStr = formatter.format(outputTip)

            result.text = "Your total tip is $outputTipStr"
        }
    }
}
