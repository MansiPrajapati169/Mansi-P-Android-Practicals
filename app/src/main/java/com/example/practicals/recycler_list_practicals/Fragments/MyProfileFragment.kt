package com.example.practicals.recycler_list_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.Adapters.ExpandableListAdapter
import com.example.practicals.recycler_list_practicals.Utils.ExpandableListData.data
import kotlinx.android.synthetic.main.fragment_my_profile.*

class MyProfileFragment : Fragment() {

    private var adapter: ExpandableListAdapter? = null
    private var titleList: List<String>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (expandableListview != null) {
            val listData = data
            titleList = ArrayList(listData.keys)
            adapter = ExpandableListAdapter(requireContext(),titleList as ArrayList<String>, listData)
            expandableListview!!.setAdapter(adapter)
        }
    }
}
