package com.example.practicals.activity_intent_fragment_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practicals.R
import com.example.practicals.activity_intent_fragment_practicals.ModelClass.SharedViewModel
import kotlinx.android.synthetic.main.fragment_view_message.*

class ViewMessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.fragment_view_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val model = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        model.message.observe(viewLifecycleOwner, Observer {
            textViewReceiver.text = it
        })
    }
}