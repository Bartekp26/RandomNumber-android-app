package com.example.randomnumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils.isEmpty
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Generate Number
        btnGenerateNumber.setOnClickListener{
            error.text = ""

            val minNumber = when {
                minNumberToGenerate.text.toString() == "" -> {
                    Int.MIN_VALUE
                }
                minNumberToGenerate.text.toString().toIntOrNull() == null -> {
                    error.text = getString(R.string.errorNumberIsTooSmallOrLarge)
                    return@setOnClickListener
                }
                else -> {
                    minNumberToGenerate.text.toString().toInt() }
            }

            val maxNumber = when {
                maxNumberToGenerate.text.toString() == "" -> {
                    Int.MAX_VALUE
                }
                maxNumberToGenerate.text.toString().toIntOrNull() == null -> {
                    error.text = getString(R.string.errorNumberIsTooSmallOrLarge)
                    return@setOnClickListener
                }
                else -> {
                    maxNumberToGenerate.text.toString().toInt() }
            }


            // Error checker
            when {
                minNumber > maxNumber -> {
                    error.text = getString(R.string.errorMinNumberGreaterThanMaxNumber)
                    return@setOnClickListener
                }
                minNumber == maxNumber -> {
                    error.text = getString(R.string.errorMinNumberEqualToMaxNumber)
                    return@setOnClickListener
                }
                else -> {
                    val random = Random.nextInt(minNumber, maxNumber)
                    generatedNumber.text = random.toString()
                }
            }


        }

    }
}