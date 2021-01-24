package com.example.randomStuffGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_random_boolean.*
import kotlin.random.Random

class RandomBooleanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_boolean)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btnGenerateBoolean.setOnClickListener{
            generatedBoolean.text = Random.nextBoolean().toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}