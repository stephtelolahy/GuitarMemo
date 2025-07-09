package com.telolahy.guitarmemo

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class SongActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_layout)

        val songFile = this.intent.getStringExtra(SONG_FILE_EXTRA) ?: return
        val txtRawResource = findViewById<View>(R.id.txtRawResource) as TextView
        txtRawResource.text = TextUtil.readRawTextFile(this, songFile)

        val songTitle = this.intent.getStringExtra(SONG_TITLE_EXTRA)
        title = songTitle
    }

    companion object {
        const val SONG_FILE_EXTRA: String = "songFile"
        const val SONG_TITLE_EXTRA: String = "songTitle"
    }
}
