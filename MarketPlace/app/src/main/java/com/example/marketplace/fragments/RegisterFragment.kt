package com.example.marketplace.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.marketplace.R
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.marketplace.repository.Repository
import com.example.marketplace.viewModel.RegisterViewModel
import com.example.marketplace.viewModel.RegisterViewModelFactory
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class RegisterFragment : Fragment() {

    private lateinit var registerViewModel: RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = RegisterViewModelFactory(Repository())
        registerViewModel = ViewModelProvider(this, factory).get(RegisterViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View  = inflater.inflate(R.layout.fragment_register, container, false)

        val username = view.findViewById<EditText>(R.id.editTextTextPersonName)
        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = view.findViewById<EditText>(R.id.editTextTextPassword)

        val button = view.findViewById<Button>(R.id.buttonRegister)

        val link = view.findViewById<TextView>(R.id.loginLink)

        button.setOnClickListener{
            if(isEmpty(username))
            {
                val t:Toast = Toast.makeText(activity?.applicationContext,"You must enter the name!",Toast.LENGTH_SHORT)
                t.show()
            }
            else if(!isEmail(email))
            {
                val t:Toast = Toast.makeText(activity?.applicationContext,"Enter valid email!",Toast.LENGTH_SHORT)
                t.show()
            }
            else if(!isPassword(password))
            {
                val t:Toast = Toast.makeText(activity?.applicationContext,"Password must be 8-24 length with characters and nubmers!",Toast.LENGTH_SHORT)
                t.show()
            }
            else
            {
                registerViewModel.user.value.let {
                    if (it != null) {
                        it.username = username.text.toString()
                    }
                    if (it != null) {
                        it.password = password.text.toString()
                    }
                    if(it!=null){
                        it.email = email.text.toString()
                    }
                }
                lifecycleScope.launch {
                    registerViewModel.register()
                }
            }
        }
        registerViewModel.token.observe(viewLifecycleOwner){
            val t:Toast = Toast.makeText(activity?.applicationContext,"Success registration",Toast.LENGTH_SHORT)
            t.show()
            this.findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
        link.setOnClickListener {
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.loginFragment)
        }
        return view
    }

    private fun isEmpty(text: EditText): Boolean {
        val str: String = text.text.toString()
        return str.isEmpty() || str == "Full name"
    }

    private fun isEmail(text: EditText): Boolean {
        val email: String = text.text.toString()
        return email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPassword(text:EditText) :Boolean{
        val PASSWORD_PATTERN: Pattern = Pattern.compile("[a-zA-Z0-9]{8,24}")
        val pass:String = text.text.toString()
        return pass.isNotEmpty() && PASSWORD_PATTERN.matcher(pass).matches()
    }

}