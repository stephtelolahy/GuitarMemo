package com.telolahy.guitarmemo;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by stephanohuguestelolahy on 12/19/14.
 */
public class SongModel {

    private ArrayList<Song> mList;

    public SongModel(Context context) {

        mList = new ArrayList<Song>();
        mList.add(new Song("Someone like you - Adele"));
        mList.add(new Song("All of me - John Legend"));
        mList.add(new Song("Mon incroyable fiancé - Adeline"));
    }


    public ArrayList<Song> allSongs() {

        return mList;
    }

    public ArrayList<Song> songsWithKey(String key) {

        ArrayList<Song> resultList = new ArrayList<Song>();
        for (Song element : mList) {
            if (element.title.contains(key.toLowerCase())) {
                resultList.add(element);
            }
        }
        return resultList;
    }
}
