package com.example.practicals.recycler_list_practicals.HolderClass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.RecycleViewHolder.*

class RecycleViewHolder(private var itemList: ArrayList<Details>) : RecyclerView.Adapter<ViewHolder>() {
    private lateinit var context : Context

    var peopleFilterList : ArrayList<Details> = arrayListOf()

    init {
        peopleFilterList = itemList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_recyclerview,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = peopleFilterList[position]
        holder.title?.text  = item.title
        item.image?.let { holder.image?.setImageResource(it) }
        holder.check?.isChecked = item.selected
    }

    override fun getItemCount(): Int {
        return peopleFilterList.size
    }

     fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(char: CharSequence?): FilterResults {
                val character = char.toString().lowercase()

                peopleFilterList = if (character.isEmpty()) {
                    itemList
                } else {
                    itemList.filter {
                        it.title?.lowercase()?.contains(character) == true
                    } as ArrayList<Details>
                }
                val filterResults = FilterResults()
                filterResults.values = peopleFilterList
                return  filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                peopleFilterList = p1?.values as? ArrayList<Details> ?: itemList
                notifyDataSetChanged()
            }
        }
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