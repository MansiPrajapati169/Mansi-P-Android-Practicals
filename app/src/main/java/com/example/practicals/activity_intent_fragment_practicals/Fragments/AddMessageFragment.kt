package com.example.practicals.activity_intent_fragment_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fragment_add_message.*

import com.example.practicals.activity_intent_fragment_practicals.ModelClass.SharedViewModel

class AddMessageFragment : Fragment() {
    private lateinit var model: SharedViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(com.example.practicals.R.layout.fragment_add_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        sendButton.setOnClickListener {
            model = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
            model.sendMessage(messageEditText.text)
        }
    }
}