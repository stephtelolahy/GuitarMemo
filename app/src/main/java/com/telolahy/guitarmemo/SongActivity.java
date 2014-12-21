package com.telolahy.guitarmemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SongActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);

        TextView txtRawResource = (TextView) findViewById(R.id.txtRawResource);
        txtRawResource.setText(TextUtil.readRawTextFile(this, R.raw.rawtextsample));
    }

}
