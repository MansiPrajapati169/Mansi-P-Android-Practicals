package com.example.practicals.recycler_list_practicals.HolderClass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.RecycleViewHolder.*

class RecycleViewHolder(private var itemList: Array<Details>) : RecyclerView.Adapter<ViewHolder>(){
    private lateinit var context : Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = itemList[position]
        holder.title?.text  = item.title
        item.image?.let { holder.image?.setImageResource(it) }
        holder.check?.isChecked = item.selected
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView? = null
        var image: ImageView? = null
        var check : CheckBox? = null

        init {
            title =  itemView.findViewById(R.id.titleTextView)
            image =  itemView.findViewById(R.id.pizzaImageView)
            check = itemView.findViewById(R.id.checkbox)

            check?.setOnCheckedChangeListener { _, isChecked ->
                if(isChecked) {
                    Toast.makeText(context,"${title?.text.toString()} Checked",Toast.LENGTH_SHORT).show()
                }
                itemList[adapterPosition].selected = isChecked
            }
        }
    }
}