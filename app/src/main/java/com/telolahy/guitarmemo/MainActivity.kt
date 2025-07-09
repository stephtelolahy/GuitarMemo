package com.telolahy.guitarmemo

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private var mListView: ListView? = null
    private var mModel: SongModel? = null
    private var mAdapter: SongAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        mModel = SongModel(this)
        mListView = findViewById<View>(R.id.listView1) as ListView
        mListView!!.onItemClickListener = this
        reloadListViewWithAllSongs()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchItem = menu.findItem(R.id.action_search)
        val searchView = MenuItemCompat.getActionView(searchItem) as SearchView
        searchView.queryHint = resources.getString(R.string.action_search)
        super.onCreateOptionsMenu(menu)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                reloadListViewWithSongsContainingKey(s)
                return false
            }
        })

        // When using the support library, the setOnActionExpandListener() method is
        // static and accepts the MenuItem object as an argument
        MenuItemCompat.setOnActionExpandListener(
            searchItem,
            object : MenuItemCompat.OnActionExpandListener {
                override fun onMenuItemActionCollapse(item: MenuItem): Boolean {
                    // Do something when collapsed
                    reloadListViewWithAllSongs()
                    return true // Return true to collapse action view
                }

                override fun onMenuItemActionExpand(item: MenuItem): Boolean {
                    // Do something when expanded
                    return true // Return true to expand action view
                }
            })

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_overflow -> {}
            R.id.refresh -> {}
            R.id.chords -> {
                val intent = Intent(this, ChordsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun reloadListViewWithAllSongs() {
        mAdapter = SongAdapter(this, R.layout.item_layout, mModel!!.allSongs())
        mListView!!.adapter = mAdapter
    }

    private fun reloadListViewWithSongsContainingKey(key: String) {
        mAdapter = SongAdapter(this, R.layout.item_layout, mModel!!.songsWithKey(key))
        mListView!!.adapter = mAdapter
    }

    override fun onItemClick(adapterView: AdapterView<*>?, view: View, i: Int, l: Long) {
        val selectedSong = mAdapter!!.getItem(i)
        val intent = Intent(this, SongActivity::class.java)
        intent.putExtra(SongActivity.SONG_FILE_EXTRA, selectedSong!!.file)
        intent.putExtra(SongActivity.SONG_TITLE_EXTRA, selectedSong.title)
        startActivity(intent)
    }
}
