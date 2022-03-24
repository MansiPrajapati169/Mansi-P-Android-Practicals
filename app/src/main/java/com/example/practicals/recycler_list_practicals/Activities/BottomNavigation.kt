package com.example.practicals.recycler_list_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practicals.R
import com.example.practicals.recycler_list_practicals.Fragments.HomeFragment
import com.example.practicals.recycler_list_practicals.Fragments.MyProfileFragment
import com.example.practicals.recycler_list_practicals.Fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*

class BottomNavigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, HomeFragment()).commit()
        bottomNavigation()
    }

    private fun bottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            var fragment = Fragment()

            when(item.itemId) {
                R.id.home -> fragment  = HomeFragment()
                R.id.search -> fragment  = SearchFragment()
                R.id.myProfile -> fragment  = MyProfileFragment()
            }

            supportFragmentManager.beginTransaction().replace(R.id.frameLayout,fragment).commit()
            true
        }
    }

}