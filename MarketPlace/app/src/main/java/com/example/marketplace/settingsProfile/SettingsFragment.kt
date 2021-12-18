package com.example.marketplace.settingsProfile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch


class SettingsFragment : Fragment() {
    private lateinit var settingsViewModel: SettingsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = SettingsViewModelFactory(Repository())
        settingsViewModel = ViewModelProvider(this, factory).get(SettingsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_settings, container, false)

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress4)
        val username = view.findViewById<EditText>(R.id.editTextTextUsername)
        val phone = view.findViewById<EditText>(R.id.editTextPhone)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword2)
        val button = view.findViewById<Button>(R.id.buttonOfSettings)



        button.setOnClickListener {
            settingsViewModel.user.value.let {
                if (it != null) {
                    it.username = username.text.toString()
                }
                if (it != null) {
                    it.password = password.text.toString()
                }
                if(it!=null){
                    it.email = email.text.toString()
                }
                if(it!=null){
                    it.phone_number = phone.text.toString()
                }
            }
            lifecycleScope.launch {
                settingsViewModel.updateUser()
            }

        }
        settingsViewModel.token.observe(viewLifecycleOwner){
            Log.d("SettingsFragment","Settings load...")
            findNavController().navigate(R.id.action_settingsFragment_to_profileFragment)
        }

        return view
    }

}

