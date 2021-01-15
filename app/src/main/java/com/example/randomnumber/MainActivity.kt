package com.example.randomnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate Number
        btnGenerateNumber.setOnClickListener{
            val minNumber = minNumberToGenerate.text.toString().toInt()
            val maxNumber = maxNumberToGenerate.text.toString().toInt()

            val random = Random.nextInt(minNumber, maxNumber)
            generatedNumber.text = random.toString()
        }

    }
}