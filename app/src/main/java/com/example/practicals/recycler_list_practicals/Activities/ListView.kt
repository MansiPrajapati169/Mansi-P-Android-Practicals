package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.Adapters.CustomListAdapter
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.HolderClass.ListViewHolder
import kotlinx.android.synthetic.main.list_view.*

class ListView : AppCompatActivity() {

    val mainTitle = arrayOf<String>("Domino's","Little Caesars","Papa John's Pizza","La Pino'Z")
    val subTitle = arrayOf<String>("Dil, Dosti, Domino's","Pizza! Pizza!","Better Ingredients. Better Pizza","The Giant Pizza Slice")
    val imageId = arrayOf<Int>(R.drawable.img, R.drawable.img, R.drawable.img, R.drawable.img)
    var titleArray = arrayOf<String>()
    var subTitleArray = arrayOf<String>()

    private lateinit var adapter : ListViewHolder
    private lateinit var items : Array<Details>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_view)

        listviewItems()
    }

    private fun listviewItems() {
        titleArray = resources.getStringArray(R.array.title_names)
        subTitleArray = resources.getStringArray(R.array.sub_title_names)

        val customAdapter = CustomListAdapter(this,mainTitle,subTitle,imageId)
        listview.adapter = customAdapter

        listview.setOnItemClickListener() {adapterView, view, position, id ->
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)
            Toast.makeText(this, getString(R.string.list_view_toast, itemIdAtPos), Toast.LENGTH_LONG).show()
        }

        items = Details.getListData(titleArray,subTitleArray)

        adapter = ListViewHolder(this,items)
        listview.adapter = adapter
    }
}
