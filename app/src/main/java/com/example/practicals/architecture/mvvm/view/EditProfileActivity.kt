package com.example.practicals.architecture.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.practicals.R
import com.example.practicals.architecture.getCustomText
import com.example.practicals.architecture.mvvm.viewmodel.EditProfileViewModel
import com.example.practicals.databinding.ActivityEditProfileBinding

class EditProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditProfileBinding
    private val viewModel: EditProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_edit_profile)

        setData()
    }

    private fun setData() {
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        Toast.makeText(this,binding.tvMessage.getCustomText(),Toast.LENGTH_SHORT).show()

        viewModel.email.observe(this) {
            binding.tvEmail.text = viewModel.email.value
        }

    }
}
