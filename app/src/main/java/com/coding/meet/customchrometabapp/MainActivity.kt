package com.coding.meet.customchrometabapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private val URL = "https://developer.android.com/"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val defaultChromeIntent = CustomTabsIntent.Builder().build()
        val chromeTabBtn = findViewById<Button>(R.id.chromeTabBtn)
        chromeTabBtn.setOnClickListener {
            defaultChromeIntent.launchUrl(this, Uri.parse(URL))
        }



        val customizeChromeIntent = CustomTabsIntent.Builder()
            // set Color of the Toolbar
            .setDefaultColorSchemeParams(
                CustomTabColorSchemeParams.Builder().setToolbarColor(ContextCompat.getColor(this,R.color.light_color))
                    .build()
            )
            // set Dark mode theme
            .setColorSchemeParams(
                CustomTabsIntent.COLOR_SCHEME_DARK,CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(ContextCompat.getColor(this,R.color.dark_color))
                    .build()
            )
            // Auto Hide App Bar
            .setUrlBarHidingEnabled(true)
            // Show Title
            .setShowTitle(true)
            .build()


        val customizeChromeTabBtn = findViewById<Button>(R.id.customizeChromeTabBtn)
        customizeChromeTabBtn.setOnClickListener {
            customizeChromeIntent.launchUrl(this, Uri.parse(URL))
        }
    }
}