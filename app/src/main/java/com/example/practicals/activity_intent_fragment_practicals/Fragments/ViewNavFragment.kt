package com.example.practicals.activity_intent_fragment_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practicals.R
import kotlinx.android.synthetic.main.fragment_view_nav.*

class ViewNavFragment : Fragment() {

    private val args: ViewNavFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.fragment_view_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        messageReceiveEditText.setText(args.message)

        viewNavButton.setOnClickListener {
            val action = ViewNavFragmentDirections.actionSecondToFirst().setMessageSend(messageReceiveEditText.text.toString())
            view.findNavController().navigate(action)
        }
    }
}