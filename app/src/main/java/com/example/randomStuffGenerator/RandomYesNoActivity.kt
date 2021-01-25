package com.example.randomStuffGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_random_yes_no.*
import kotlin.random.Random

class RandomYesNoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_yes_no)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnGenerateYesNo.setOnClickListener {
            val random = Random.nextBoolean()

            generatedYesNo.text = when(random) {
                true -> "Yes"
                false -> "No"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}