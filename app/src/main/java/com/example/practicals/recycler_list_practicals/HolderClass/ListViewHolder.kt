package com.example.practicals.recycler_list_practicals.HolderClass

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details

class ListViewHolder(private var activity: Activity, private var itemList: Array<Details>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, p2: ViewGroup?): View {
        var view = convertView
        val viewHolder: ViewHolder

        if (view == null) {
            view = activity.layoutInflater.inflate(R.layout.activity_custom_list_view, null)
            viewHolder = ViewHolder(view)
            view?.tag = viewHolder
        }
        else {
            viewHolder = view.tag as ViewHolder
        }

        val item = itemList[position]
        viewHolder.title?.text = item.title
        viewHolder.subTitle?.text = item.subTitle
        item.image?.let { viewHolder.image?.setImageResource(it) }

        return view as View

    }
    override fun getCount(): Int {
        return itemList.size
    }

    override fun getItem(position: Int): Details {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private class ViewHolder(row: View?){
        var title: TextView? = null
        var subTitle: TextView? = null
        var image: ImageView? = null

        init {
            title =  row?.findViewById(R.id.title)
            subTitle =  row?.findViewById(R.id.subtitle)
            image =  row?.findViewById(R.id.icon)
        }
    }
}