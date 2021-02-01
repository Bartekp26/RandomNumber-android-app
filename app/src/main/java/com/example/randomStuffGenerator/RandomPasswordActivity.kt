package com.example.randomStuffGenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_random_password.*
import kotlin.random.Random

class RandomPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random_password)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val lettersArray = charArrayOf('a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', 'e', 'E', 'f', 'F', 'g', 'G', 'h', 'H', 'i', 'I', 'j', 'J', 'k', 'K', 'l', 'L', 'm', 'M', 'n', 'N', 'o', 'O', 'p', 'P', 'q', 'Q', 'r', 'R', 's', 'S', 't', 'T', 'u', 'U', 'v', 'V', 'w', 'W', 'x', 'X', 'y', 'Y', 'z', 'Z', '{', '}', '(', ')', '[', ']', '#', ':', ';', '^', ',', '.', '?', '!', '|', '&', '_', '`', '~', '@', '$', '%', '/', '\\', '=', '+', '-', '*', '"')
        generatedPassword.movementMethod = ScrollingMovementMethod()

        btnGeneratePassword.setOnClickListener {
            error.text = ""

            val lengthOfPassword = when{
                lengthOfPassword.text.toString() == "" -> {
                    error.text = resources.getString(R.string.errorNoLengthOfPassword)
                    return@setOnClickListener
                }
                lengthOfPassword.text.toString().toInt() < 0 -> {
                    error.text = resources.getString(R.string.errorLengthOfPasswordIsNegative)
                    return@setOnClickListener
                }
                lengthOfPassword.text.toString().toInt() > 100 || lengthOfPassword.text.toString().toInt() < 2 -> {
                    error.text = resources.getString(R.string.errorLengthOfPasswordTooSmallOrLarge)
                    return@setOnClickListener
                }
                else -> lengthOfPassword.text.toString().toInt()
            }

            val random = (1..lengthOfPassword)
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