package com.example.practicals.recycler_list_practicals.Adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practicals.recycler_list_practicals.Utils.Constant.ONE
import com.example.practicals.recycler_list_practicals.Utils.Constant.TWO
import com.example.practicals.recycler_list_practicals.Fragments.MyFavoritesFragment
import com.example.practicals.recycler_list_practicals.Fragments.RecentFragment
import com.example.practicals.recycler_list_practicals.Activities.ViewPagerActivity

class ViewPagerAdapter(activity: ViewPagerActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return TWO
    }

    override fun createFragment(position: Int): Fragment {

        when(position) {
            ONE -> return MyFavoritesFragment()
        }

        return RecentFragment()
    }
}