package com.example.practicals.web_services.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.practicals.R
import com.example.practicals.web_services.Data
import com.example.practicals.web_services.DisplayUserActivity
import com.squareup.picasso.Picasso

class DelayedResponseAdapter (private var itemList: List<Data>) : RecyclerView.Adapter<DelayedResponseAdapter.ViewHolder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.delayed_custom_recycler_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var item = itemList[position]
        holder.firstName?.text  = item.firstName
        holder.email?.text  = item.email
        Picasso.get().load(item.avatar).into(holder.image)
        holder.card?.setOnClickListener {
            val intent = Intent(context, DisplayUserActivity::class.java)
            intent.putExtra("id",item.id)
            context.startActivity(intent)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var firstName: TextView? = null
        var image: ImageView? = null
        var email: TextView? = null
        var card: CardView? = null

        init {
            firstName =  itemView.findViewById(R.id.tvFirstName)
            email =  itemView.findViewById(R.id.tvEmail)
            image = itemView.findViewById(R.id.rvImage)
            card = itemView.findViewById(R.id.itemCardView)
        }
    }

}