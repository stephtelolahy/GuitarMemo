package com.telolahy.guitarmemo;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class ChordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chords_layout);

        setTitle(getString(R.string.chords));

        WebView webView = (WebView) this.findViewById(R.id.webView1);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.loadUrl("file:///android_asset/Cowboy-Chords.jpg");
    }

}
