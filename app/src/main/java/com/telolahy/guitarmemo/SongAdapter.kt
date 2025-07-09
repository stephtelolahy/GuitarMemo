package com.telolahy.guitarmemo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView

/**
 * Created by stephanohuguestelolahy on 12/19/14.
 */
class SongAdapter(context: Context, itemResource: Int, items: List<Song?>) :
    ArrayAdapter<Song?>(context, itemResource, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //Inflate the view
        val itemView: LinearLayout
        if (convertView == null) {
            itemView = LinearLayout(context)
            val inflater = Context.LAYOUT_INFLATER_SERVICE
            val vi = context.getSystemService(inflater) as LayoutInflater
            vi.inflate(R.layout.item_layout, itemView, true)
        } else {
            itemView = convertView as LinearLayout
        }

        val song = getItem(position)

        val textViewTitle = itemView.findViewById<View>(R.id.text1) as TextView
        textViewTitle.text = song!!.title

        return itemView
    }
}
