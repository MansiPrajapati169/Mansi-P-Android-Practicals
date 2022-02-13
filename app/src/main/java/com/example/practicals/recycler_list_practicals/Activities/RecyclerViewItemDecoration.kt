package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import android.widget.LinearLayout

import androidx.recyclerview.widget.DividerItemDecoration
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.CustomItemDecoration
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.RecyclerViewItemHolder
import kotlinx.android.synthetic.main.activity_recycler_view.itemRecyclerView


class RecyclerViewItemDecoration : AppCompatActivity() {
    private lateinit var items : ArrayList<Details>
    var titleArray = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_item_decoration)
        itemDecoration()
    }

    private fun itemDecoration() {
        titleArray = resources.getStringArray(R.array.title_names)

        items = Details.getRecyclerData(titleArray)

        val adapter = RecyclerViewItemHolder(items)
        val gridLayout = GridLayoutManager(this,3)

        itemRecyclerView.layoutManager = gridLayout
        itemRecyclerView.adapter = adapter
        itemRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        itemRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayout.HORIZONTAL))
        itemRecyclerView.addItemDecoration(CustomItemDecoration(10))
    }
}