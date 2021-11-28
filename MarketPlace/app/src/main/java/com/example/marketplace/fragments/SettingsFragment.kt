package com.example.marketplace.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.viewModel.MainViewModel

class SettingsFragment : Fragment() {
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_settings, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress4)
        val username = view.findViewById<EditText>(R.id.editTextTextUsername)
        val phone = view.findViewById<EditText>(R.id.editTextPhone)

        viewModel.setUserName(username.text.toString())
        viewModel.setPhone(phone.text.toString())

        val button = view.findViewById<Button>(R.id.buttonOfSettings)

        button.setOnClickListener {
            this.findNavController().navigate(R.id.action_settingsFragment_to_profileFragment)
        }

        return view
    }

}