package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.RecycleViewHolder
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var items : Array<Details>
    var titleArray = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        customRecyclerView()
    }

    private fun customRecyclerView() {
        titleArray = resources.getStringArray(R.array.title_names)

        items = arrayOf(
            Details(title = titleArray[0], image = R.drawable.img),
            Details(title = titleArray[1], image = R.drawable.img),
            Details(title = titleArray[2], image = R.drawable.img),
            Details(title = titleArray[3], image = R.drawable.img),
            Details(title = titleArray[0], image = R.drawable.img),
            Details(title = titleArray[1], image = R.drawable.img),
            Details(title = titleArray[2], image = R.drawable.img),
            Details(title = titleArray[3], image = R.drawable.img),
            Details(title = titleArray[0], image = R.drawable.img),
            Details(title = titleArray[1], image = R.drawable.img),
            Details(title = titleArray[2], image = R.drawable.img),
            Details(title = titleArray[3], image = R.drawable.img))

        val adapter = RecycleViewHolder(items)
        val linearLayout = LinearLayoutManager(this)
        itemRecyclerView.layoutManager = linearLayout
        itemRecyclerView.adapter = adapter
    }
}