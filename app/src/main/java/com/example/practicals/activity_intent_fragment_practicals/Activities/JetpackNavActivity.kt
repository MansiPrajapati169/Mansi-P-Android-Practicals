package com.example.practicals.activity_intent_fragment_practicals.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.practicals.R
import kotlinx.android.synthetic.main.activity_jetpack_nav.*

class JetpackNavActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jetpack_nav)

        bottomNavigationBind()
    }

    private fun bottomNavigationBind() {
        val navController= findNavController(R.id.navFragment)
        bottomJetpackNavigation.setupWithNavController(navController)
    }
}