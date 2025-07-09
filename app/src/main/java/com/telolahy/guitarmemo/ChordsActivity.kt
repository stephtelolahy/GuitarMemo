package com.telolahy.guitarmemo

import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class ChordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chords_layout)

        title = getString(R.string.chords)

        val webView = findViewById<View>(R.id.webView1) as WebView
        webView.settings.builtInZoomControls = true
        webView.loadUrl("file:///android_asset/Cowboy-Chords.jpg")
    }
}
