package com.example.practicals.recycler_list_practicals.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_list_recycler_view_pager.*

class ListRecyclerViewPager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_recycler_view_pager)

        listviewTask()
        recyclerViewTask()
        itemDecorationTask()
        viewPagerTask()
        bottomNavigationTask()
    }

    private fun listviewTask() {
        listViewTask.setOnClickListener {
            intent = Intent(applicationContext, ListView::class.java)
            startActivity(intent)
        }
    }

    private fun recyclerViewTask() {
        recyclerViewTask.setOnClickListener {
            intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun itemDecorationTask() {
        itemDecorationTask.setOnClickListener {
            intent = Intent(applicationContext, RecyclerViewItemDecoration::class.java)
            startActivity(intent)
        }
    }

    private fun viewPagerTask() {
        viewPagerTask.setOnClickListener {
            intent = Intent(applicationContext, ViewPagerActivity::class.java)
            startActivity(intent)
        }
    }

    private fun bottomNavigationTask() {
        bottomNavigationTask.setOnClickListener {
            intent = Intent(applicationContext, BottomNavigation::class.java)
            startActivity(intent)
        }
    }
}