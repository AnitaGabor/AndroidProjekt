package com.example.marketplace.profile.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.profile.viewModel.UserInfoViewModel
import com.example.marketplace.profile.viewModel.UserInfoViewModelFactory
import com.example.marketplace.repository.Repository


class ProfileFragment : Fragment() {

    private lateinit var viewModel: UserInfoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = UserInfoViewModelFactory(Repository())
        viewModel = ViewModelProvider(this,factory).get(UserInfoViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_profile, container, false)


        val email = view.findViewById<TextView>(R.id.emailTextView)
        val username = view.findViewById<TextView>(R.id.usernameTextView)
        val phone = view.findViewById<TextView>(R.id.phoneNumberTextView)
        val button = view.findViewById<Button>(R.id.settingsButton)

        viewModel.user.observe(viewLifecycleOwner){
            email.text = it.email
            username.text = it.username
            phone.text = it.phone_number
        }

        button.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_settingsFragment)
        }


        return view
    }


}