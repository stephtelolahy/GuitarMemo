package com.telolahy.guitarmemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private SongModel mModel;
    private SongAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layout);
        mModel = new SongModel(this);
        mListView = (ListView) findViewById(R.id.listView1);
        mListView.setOnItemClickListener(this);
        reloadListViewWithAllSongs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setQueryHint(getResources().getString(R.string.action_search));
        super.onCreateOptionsMenu(menu);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                reloadListViewWithSongsContainingKey(s);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_overflow:
                break;
            case R.id.refresh:
                break;
            case R.id.chords:
                Intent intent = new Intent(this, ChordsActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void reloadListViewWithAllSongs() {

        mAdapter = new SongAdapter(this, R.layout.item_layout, mModel.allSongs());
        mListView.setAdapter(mAdapter);

    }

    private void reloadListViewWithSongsContainingKey(String key) {

        mAdapter = new SongAdapter(this, R.layout.item_layout, mModel.songsWithKey(key));
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        Song selectedSong = mAdapter.getItem(i);
        Intent intent = new Intent(this, SongActivity.class);
        intent.putExtra(SongActivity.SONG_FILE_EXTRA, selectedSong.file);
        intent.putExtra(SongActivity.SONG_TITLE_EXTRA, selectedSong.title);
        startActivity(intent);
    }
}
