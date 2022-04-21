package com.example.practicals.activity_intent_fragment_practicals.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practicals.R
import kotlinx.android.synthetic.main.fragment_add_nav.*

class AddNavFragment : Fragment() {

    private val args: AddNavFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        return inflater.inflate(R.layout.fragment_add_nav, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageNavEditText.setText(args.messageSend)

        sendNavButton.setOnClickListener {
            val action = AddNavFragmentDirections.actionFirstToSecond().setMessage(messageNavEditText.text.toString())
            view.findNavController().navigate(action)
        }
    }
}