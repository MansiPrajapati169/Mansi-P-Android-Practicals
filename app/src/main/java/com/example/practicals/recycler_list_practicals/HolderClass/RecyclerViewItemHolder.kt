package com.example.practicals.recycler_list_practicals.HolderClass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details

class RecyclerViewItemHolder(private var itemList: Array<Details>) : RecyclerView.Adapter<RecyclerViewItemHolder.ViewHolder>(){
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.title?.text  = item.title
        item.image?.let { holder.image?.setImageResource(it) }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var image: ImageView? = null

        init {
            title =  itemView.findViewById(R.id.itemTitleTextView)
            image =  itemView.findViewById(R.id.pizzasImageView)
        }
    }
}