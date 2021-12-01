package com.example.marketplace.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.viewModel.MainViewModel
import androidx.core.app.ActivityCompat.startActivityForResult
import android.provider.MediaStore

import android.graphics.Bitmap

import android.app.Activity








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

        email.setText(viewModel.getEmail());
        val button = view.findViewById<Button>(R.id.buttonOfSettings)



        button.setOnClickListener {
            viewModel.setUserName(username.text.toString())
            viewModel.setPhone(phone.text.toString())
            this.findNavController().navigate(R.id.action_settingsFragment_to_profileFragment)
        }

        return view
    }

}

