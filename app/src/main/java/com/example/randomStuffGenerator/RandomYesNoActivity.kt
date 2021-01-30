package com.example.randomStuffGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_random_yes_no.*
import kotlin.random.Random

class RandomYesNoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_yes_no)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val history: MutableList<String> = ArrayList()
        yesNoHistory.movementMethod = ScrollingMovementMethod()

        btnGenerateYesNo.setOnClickListener {
            val random = when(Random.nextBoolean()){
                true -> "Yes"
                false -> "No"
            }

            generatedYesNo.text = random

            history.add(random)
            yesNoHistory.text = history.joinToString(separator = "    ")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}