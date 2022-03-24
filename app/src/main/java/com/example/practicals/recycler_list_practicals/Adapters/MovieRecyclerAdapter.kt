package com.example.practicals.recycler_list_practicals.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details

class MovieRecyclerAdapter(private var itemList: Array<Details>) : RecyclerView.Adapter<MovieRecyclerAdapter.ViewHolder>() {
    private lateinit var context : Context
    var isExpandable : Boolean? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_details_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = itemList[position]
        holder.name?.text  = item.name
        holder.realname?.text  = item.realName
        holder.team?.text  = item.team
        holder.firstAppearance?.text  = item.firstAppearance

        isExpandable = itemList[position].exapndable
        holder.expandableLayout?.visibility  = if (isExpandable as Boolean) View.VISIBLE else View.GONE

        holder.linearLayout?.setOnClickListener() {
            var item = itemList[position]
            item.exapndable = !item.exapndable
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView? = null
        var realname: TextView? = null
        var team : TextView? = null
        var firstAppearance : TextView? = null
        var expandableLayout : ConstraintLayout? = null
        var linearLayout : ConstraintLayout? = null

        init {
            name =  itemView.findViewById(R.id.movieNameTextView)
            realname =  itemView.findViewById(R.id.realNameTextView)
            team = itemView.findViewById(R.id.teamTextView)
            firstAppearance = itemView.findViewById(R.id.firstAppearanceTextView)
            expandableLayout = itemView.findViewById(R.id.expandableLayout)
            linearLayout = itemView.findViewById(R.id.mainLayout)
        }
    }
}