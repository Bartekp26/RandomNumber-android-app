package com.example.randomStuffGenerator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_random_number.*
import kotlin.random.Random

class RandomNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_number)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val history: MutableList<String> = ArrayList()
        numberHistory.movementMethod = ScrollingMovementMethod()

        // Generate Number
        btnGenerateNumber.setOnClickListener {
            error.text = ""

            val minNumber = when {
                minNumberToGenerate.text.toString() == "" -> Int.MIN_VALUE
                minNumberToGenerate.text.toString().toIntOrNull() == null -> {
                    error.text = getString(R.string.errorNumberIsTooSmallOrLarge)
                    return@setOnClickListener
                }
                else -> minNumberToGenerate.text.toString().toInt()
            }

            val maxNumber = when {
                maxNumberToGenerate.text.toString() == "" -> Int.MAX_VALUE
                maxNumberToGenerate.text.toString().toIntOrNull() == null -> {
                    error.text = getString(R.string.errorNumberIsTooSmallOrLarge)
                    return@setOnClickListener
                }
                else -> maxNumberToGenerate.text.toString().toInt()
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
                    val random = Random.nextInt(minNumber, maxNumber).toString()
                    generatedNumber.text = random
                    history.add(random)
                }
            }
            numberHistory.text = history.joinToString(separator = "    ")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}