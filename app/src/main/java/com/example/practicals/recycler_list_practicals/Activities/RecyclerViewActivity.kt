package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.RecycleViewHolder
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {
    private lateinit var items : ArrayList<Details>
    var titleArray = arrayOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        customRecyclerView()
    }

    private fun customRecyclerView() {
        titleArray = resources.getStringArray(R.array.title_names)

        items = Details.getRecyclerData(titleArray)

        val adapter = RecycleViewHolder(items)
        itemRecyclerView.adapter = adapter
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.getFilter().filter(newText)
                return true
            }

        })
}
}