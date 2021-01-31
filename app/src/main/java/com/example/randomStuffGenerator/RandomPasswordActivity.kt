package com.example.randomStuffGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_random_password.*
import kotlin.random.Random

class RandomPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_password)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lettersArray = charArrayOf('a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '{', '}', '(', ')', '[', ']', '#', ':', ';', '^', ',', '.', '?', '!', '|', '&', '_', '`', '~', '@', '$', '%', '/', '\\', '=', '+', '-', '*', '"')

        btnGeneratePassword.setOnClickListener {
            val random = (1..lengthOfPassword.text.toString().toInt())
                .map{ Random.nextInt(0, lettersArray.size) }
                .map(lettersArray::get)
                .joinToString("")

            generatedPassword.text = random
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}