package com.telolahy.guitarmemo

import android.content.Context
import java.io.IOException
import java.util.Locale

/**
 * Created by stephanohuguestelolahy on 12/19/14.
 */
class SongModel(context: Context) {
    private val mList = ArrayList<Song>()

    init {
        try {
            val list = context.assets.list("songs")
            for (file in list!!) {
                mList.add(Song(file.substring(0, file.lastIndexOf('.')), "songs/$file"))
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


    fun allSongs(): ArrayList<Song> {
        return mList
    }

    fun songsWithKey(key: String): ArrayList<Song> {
        val resultList = ArrayList<Song>()
        for (element in mList) {
            if (element.title.lowercase(Locale.getDefault())
                    .contains(key.lowercase(Locale.getDefault()))
            ) {
                resultList.add(element)
            }
        }
        return resultList
    }
}
