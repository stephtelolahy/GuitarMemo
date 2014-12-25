package com.telolahy.guitarmemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class SongActivity extends Activity {

    public static final String SONG_FILE_EXTRA = "songFile";
    public static final String SONG_TITLE_EXTRA = "songTitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_layout);

        String songFile = this.getIntent().getStringExtra(SONG_FILE_EXTRA);
        TextView txtRawResource = (TextView) findViewById(R.id.txtRawResource);
        txtRawResource.setText(TextUtil.readRawTextFile(this, songFile));

        String songTitle = this.getIntent().getStringExtra(SONG_TITLE_EXTRA);
        setTitle(songTitle);
    }

}
