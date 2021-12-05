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
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import com.example.marketplace.viewModel.LoginViewModel
import com.example.marketplace.viewModel.LoginViewModelFactory
import com.example.marketplace.viewModel.MainViewModel
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class LoginFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = LoginViewModelFactory(Repository())
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_login, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        val username = view.findViewById<EditText>(R.id.editTextTextUserName)
        val password = view.findViewById<EditText>(R.id.editTextTextPasswordLogin)

        val button = view.findViewById<Button>(R.id.buttonLogIn)
        val buttonSingUp = view.findViewById<Button>(R.id.buttonSingUp)

        val link = view.findViewById<TextView>(R.id.forgotPasswordLink)

        button.setOnClickListener {
            if(username.text.toString() == "Username" || !isPassword(password))
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Enter data!",
                    Toast.LENGTH_SHORT)
                t.show()
            }
                loginViewModel.user.value.let {
                    if (it != null) {
                        it.username = username.text.toString()
                    }
                    if (it != null) {
                        it.password = password.text.toString()
                    }
                }
                lifecycleScope.launch {
                    loginViewModel.login()
                }
        }

        loginViewModel.token.observe(viewLifecycleOwner){
            val t: Toast = Toast.makeText(activity?.applicationContext,"Login...",
                Toast.LENGTH_SHORT)
            t.show()
            findNavController().navigate(R.id.action_loginFragment_to_settingsFragment)
        }

        link.setOnClickListener {
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.forgetPasswordFragment)
        }
        buttonSingUp.setOnClickListener{
            Navigation.findNavController(this.requireActivity(),R.id.myNavHostFragment).navigate(R.id.registerFragment)
        }

        return view
    }
    private fun isPassword(text:EditText) :Boolean{
        val PASSWORD_PATTERN: Pattern = Pattern.compile("[a-zA-Z0-9]{8,24}")
        val pass:String = text.text.toString()
        return pass.isNotEmpty() && PASSWORD_PATTERN.matcher(pass).matches()
    }
}