package com.example.marketplace.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.marketplace.R
import com.example.marketplace.viewModel.MainViewModel


class ProfileFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_profile, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val email = view.findViewById<TextView>(R.id.emailTextView)
        val username = view.findViewById<TextView>(R.id.usernameTextView)
        val phone = view.findViewById<TextView>(R.id.phoneNumberTextView)

        email.text = viewModel.getEmail()
        username.text = viewModel.getUserName()
        phone.text = viewModel.getPhone()

        return view
    }


}