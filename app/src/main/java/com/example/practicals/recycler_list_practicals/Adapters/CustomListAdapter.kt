package com.example.practicals.recycler_list_practicals.Adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.practicals.R

class CustomListAdapter(private val context: Activity, private val maintitle: Array<String>, private val subtitle: Array<String>, private val imageId: Array<Int>) : BaseAdapter(){

    override fun getCount(): Int {
        return maintitle.size
    }

    override fun getItem(position : Int): Any {
        return maintitle[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val inflater = context.layoutInflater
        val rowView = inflater.inflate(R.layout.activity_custom_list_view, null, true)
        val image = rowView.findViewById<ImageView>(R.id.icon)
        val title = rowView.findViewById<TextView>(R.id.title)
        val subTitle = rowView.findViewById<TextView>(R.id.subtitle)
        title.text = this.maintitle[position]
        image.setImageResource(imageId[position])
        subTitle.text = this.subtitle[position]
        return rowView
    }

}