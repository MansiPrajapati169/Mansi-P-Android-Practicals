package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.Adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_view_pager.*

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPagerTask(viewPager)
    }

    private fun viewPagerTask(viewPager: ViewPager2) {
        val titles = resources.getStringArray(R.array.page_names)
        viewPager.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) { myTabLayout: TabLayout.Tab, position: Int -> myTabLayout.text = titles[position] }.attach()
    }
}