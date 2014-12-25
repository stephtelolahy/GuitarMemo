package com.telolahy.guitarmemo;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by stephanohuguestelolahy on 12/19/14.
 */
public class SongModel {

    private ArrayList<Song> mList;

    public SongModel(Context context) {

        mList = new ArrayList<Song>();
        try {
            String[] list = context.getAssets().list("songs");
            for (String file : list) {
                mList.add(new Song(file.substring(0, file.lastIndexOf('.')), "songs/"+file));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
