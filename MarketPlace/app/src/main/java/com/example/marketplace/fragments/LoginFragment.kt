package com.example.marketplace.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.viewModel.MainViewModel
import java.util.regex.Pattern


class LoginFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddressLogin)
        val password = view.findViewById<EditText>(R.id.editTextTextPasswordLogin)

        val button = view.findViewById<Button>(R.id.buttonLogIn)
        val buttonSingUp = view.findViewById<Button>(R.id.buttonSingUp)

        val link = view.findViewById<TextView>(R.id.forgotPasswordLink)

        button.setOnClickListener {
            if(!isEmail(email) || !isPassword(password))
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Enter data!",
                    Toast.LENGTH_SHORT)
                t.show()
            }
            viewModel.setEmail(email.text.toString());
            val t: Toast = Toast.makeText(activity?.applicationContext,"Login...",
                Toast.LENGTH_SHORT)
            t.show()
            this.findNavController().navigate(R.id.action_loginFragment_to_settingsFragment)

        }

        link.setOnClickListener {
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.forgetPasswordFragment)
        }
        buttonSingUp.setOnClickListener{
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.registerFragment)
        }

        return view
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