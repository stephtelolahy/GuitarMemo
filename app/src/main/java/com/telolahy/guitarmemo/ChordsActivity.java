package com.telolahy.guitarmemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;


public class ChordsActivity extends ActionBarActivity {

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
