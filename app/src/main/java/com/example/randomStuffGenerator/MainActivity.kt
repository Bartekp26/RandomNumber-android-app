package com.example.randomStuffGenerator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonToRandomNumberActivity.setOnClickListener {
            val intent = Intent(this, RandomNumberActivity::class.java)
            startActivity(intent)
        }

        buttonToRandomBooleanActivity.setOnClickListener {
            val intent = Intent(this, RandomBooleanActivity::class.java)
            startActivity(intent)
        }

        buttonToRandomYesNoActivity.setOnClickListener {
            val intent = Intent(this, RandomYesNoActivity::class.java)
            startActivity(intent)
        }

        buttonToRandomLetterActivity.setOnClickListener {
            val intent = Intent(this, RandomLetterActivity::class.java)
            startActivity(intent)
        }

        buttonToRandomPasswordActivity.setOnClickListener {
            val intent = Intent(this, RandomPasswordActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.menuAbout -> {
            val intent = Intent(this, AboutActivity::class.java)
            startActivity(intent)
            true
        }
        R.id.menuExit -> {
            moveTaskToBack(true)
            exitProcess(-1)
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }
}