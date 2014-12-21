package com.telolahy.guitarmemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by stephanohuguestelolahy on 12/19/14.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, int itemResource, List<Song> items) {
        super(context, itemResource, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Inflate the view
        LinearLayout itemView;
        if (convertView == null) {
            itemView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(inflater);
            vi.inflate(R.layout.item_layout, itemView, true);
        } else {
            itemView = (LinearLayout) convertView;
        }

        Song song = getItem(position);

        TextView textViewTitle = (TextView) itemView.findViewById(R.id.text1);
        textViewTitle.setText(song.title);

        return itemView;
    }
}
