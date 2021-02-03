package com.example.randomStuffGenerator

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import mehdi.sakout.aboutpage.AboutPage
import mehdi.sakout.aboutpage.Element


class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val versionElement = Element()
        versionElement.title = "Version " + resources.getString(R.string.app_versions)

        val aboutPage: View = AboutPage(this)
                .setDescription(resources.getString(R.string.app_description))
                .isRTL(false)
                .addItem(versionElement)
                .addGroup("Connect with us")
                .addEmail(resources.getString(R.string.author_email))
                .addPlayStore("")
                .addGitHub("Bartekp26")
                .create()

        setContentView(aboutPage)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}