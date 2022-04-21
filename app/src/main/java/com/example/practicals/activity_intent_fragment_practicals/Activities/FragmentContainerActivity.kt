package com.example.practicals.activity_intent_fragment_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.practicals.R
import com.example.practicals.activity_intent_fragment_practicals.Fragments.AddMessageFragment
import com.example.practicals.activity_intent_fragment_practicals.Fragments.GalleryFragment
import com.example.practicals.activity_intent_fragment_practicals.Fragments.ViewMessageFragment
import kotlinx.android.synthetic.main.activity_fragment_container.*

class FragmentContainerActivity : AppCompatActivity() {

    private val galleryFragment  = GalleryFragment()
    private var fragment : Fragment = galleryFragment
    private val addMessageFragment  = AddMessageFragment()
    private val viewMessageFragment = ViewMessageFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_container)

        setData()
    }

    private fun setData() {
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragmentContainer, addMessageFragment).hide(addMessageFragment)
            add(R.id.fragmentContainer, viewMessageFragment).hide(viewMessageFragment)
        }.commit()
        bottomNavigation()
    }

    private fun bottomNavigation() {
        bottomNavigationFragment.setOnItemReselectedListener{ item->

            when (item.itemId) {

                R.id.galleryFragment -> {
                    supportFragmentManager.beginTransaction().hide(fragment).show(galleryFragment).commit()
                    fragment = galleryFragment
                }

                R.id.addMessageFragment -> {
                    supportFragmentManager.beginTransaction().hide(fragment).show(addMessageFragment).commit()
                    fragment = addMessageFragment
                }

                R.id.viewMessageFragment -> {
                    supportFragmentManager.beginTransaction().hide(fragment).show(viewMessageFragment).commit()
                    fragment = viewMessageFragment
                }
            }

            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer,fragment).commit()
            true
        }
    }
}