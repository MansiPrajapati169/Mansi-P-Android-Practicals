package com.example.practicals.recycler_list_practicals.Adapters

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.example.practicals.R

class ExpandableListAdapter (val context : Context,private val titleList: List<String>, private val dataList: HashMap<String, List<String>>
) : BaseExpandableListAdapter() {

    override fun getGroupView(listPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val listTitle = getGroup(listPosition) as String

        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.movie_name, null)
        }

        val listTitleTextView = convertView?.findViewById<TextView>(R.id.movieNameListTextView)
        listTitleTextView?.setTypeface(null, Typeface.BOLD)
        listTitleTextView?.text = listTitle

        return convertView as View
    }

    override fun getChildView(listPosition: Int, expandedListPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val expandedListText = getChild(listPosition, expandedListPosition) as String

        if (convertView == null) {
            val layoutInflater = this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = layoutInflater.inflate(R.layout.movie_details_list, null)
        }

        val expandedListTextView = convertView?.findViewById<TextView>(R.id.moviDetailTextView)
        expandedListTextView?.text = expandedListText

        return convertView as View
    }

    override fun getGroupCount(): Int {
        return this.titleList.size
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return this.dataList[this.titleList[listPosition]]?.size as Int
    }

    override fun getGroup(listPosition: Int): Any {
        return this.titleList[listPosition]
    }

    override fun getChild(listPosition: Int, expandedListPosition: Int): String? {
        return this.dataList[this.titleList[listPosition]]?.get(expandedListPosition)
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(listPosition: Int, expandedListPosition: Int): Boolean {
        return true
    }
}