package com.example.randomStuffGenerator

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_random_letter.*
import kotlin.random.Random

class RandomLetterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_letter)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lettersArray = charArrayOf('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z')

        val history: MutableList<String> = ArrayList()
        letterHistory.movementMethod = ScrollingMovementMethod()

        btnGenerateLetter.setOnClickListener {
            val randomChar = (1..1)
                    .map { Random.nextInt(0, lettersArray.size) }
                    .map(lettersArray::get)
                    .joinToString("")

            generatedLetter.text = randomChar
            history.add(randomChar)
            letterHistory.text = history.joinToString(separator = "    ")
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}