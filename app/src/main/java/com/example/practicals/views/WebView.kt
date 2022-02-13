package com.example.practicals.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import com.example.practicals.R
import com.example.practicals.utils.Constants
import kotlinx.android.synthetic.main.activity_web_view.*

class WebView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        loadPage()
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
    }

    private fun loadPage() {
        webView.loadUrl(Constants.PAGE_URL)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.fade_out, R.anim.fade_in)
    }
}
