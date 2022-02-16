package com.example.practicals.activity_intent_fragment_practicals.Fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.practicals.R
import kotlinx.android.synthetic.main.fragment_gallery.*
import android.content.ContentValues
import android.content.UriMatcher
import android.graphics.Bitmap
import android.net.Uri
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toDrawable
import java.io.File

class GalleryFragment : Fragment() {

    private lateinit var picture: ActivityResultLauncher<Intent>
    private lateinit var intent : Intent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {

        picture = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->

            result.data?.let {
                val image = it.data
                ivImage.setImageURI(image)
            }
        }
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        btnOpenGallery.setOnClickListener {
            intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = getString(R.string.intent_type)
            picture.launch(intent)
        }
    }
}