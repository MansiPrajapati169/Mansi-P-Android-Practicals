package com.example.practicals.recycler_list_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.DataClass.Details
import com.example.practicals.recycler_list_practicals.Adapters.MovieRecyclerAdapter
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : Fragment() {
    private lateinit var itemList : Array<Details>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)

    }

    private fun initData(): Array<Details> {
        itemList = arrayOf(
            Details(name = "Captain America",realName =  "Steve Rogers",team = "Avengers",firstAppearance = "1941"),
            Details(name = "Iron Man",realName =  "Tony Stark",team = "Avengers",firstAppearance = "1963"),
            Details(name = "Wolvarine",realName =  "James Howlett",team = "X-Men",firstAppearance ="1974"),
            Details(name = "Spiderman",realName =  "Peter Parker",team = "Avengers",firstAppearance ="1962"),
            Details(name = "Thor",realName =  "Thor Odinson",team = "Avengers",firstAppearance ="1962"),
            Details(name = "Captain America",realName =  "Steve Rogers",team = "Avengers",firstAppearance ="1941"),
            Details(name = "Iron Man", realName = "Tony Stark",team = "Avengers",firstAppearance ="1963"),
            Details(name = "Wolvarine",realName =  "James Howlett",team = "X-Men",firstAppearance ="1974"),
            Details(name = "Spiderman", realName =  "Peter Parker",team = "Avengers",firstAppearance ="1962"),
            Details(name = "Thor", realName = "Thor Odinson",team = "Avengers",firstAppearance ="1962"))

        return itemList
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieRecyclerAdapter(initData())
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

}