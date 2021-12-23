package com.example.marketplace.login.fragment

import android.os.Bundle
import android.util.Log
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
import com.example.marketplace.MainViewModel
import com.example.marketplace.R
import com.example.marketplace.login.viewmodel.LoginViewModel
import com.example.marketplace.login.viewmodel.LoginViewModelFactory
import com.example.marketplace.repository.Repository
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import java.util.regex.Pattern


class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = LoginViewModelFactory(Repository())
        loginViewModel = ViewModelProvider(this, factory).get(LoginViewModel::class.java)
        viewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_login, container, false)
        val username = view.findViewById<TextInputEditText>(R.id.editTextTextUserName)
        val password = view.findViewById<TextInputEditText>(R.id.editTextTextPasswordLogin)
        val password_til = view.findViewById<TextInputLayout>(R.id.passwordInput)
        val name_til = view.findViewById<TextInputLayout>(R.id.usernameInput)

        val button = view.findViewById<Button>(R.id.buttonLogIn)
        val buttonSingUp = view.findViewById<Button>(R.id.buttonSingUp)

        val link = view.findViewById<TextView>(R.id.forgotPasswordLink)

        button.setOnClickListener {
            if(username.text.toString().isEmpty())
            {
                name_til.setError("Please enter username.")

            }
            else if(!isPassword(password)){
                password_til.setError("Your password is incorrect.")
            }
            else
            {   password_til.setError(null)
                name_til.setError(null)
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
        }

        loginViewModel.token.observe(viewLifecycleOwner){
            Log.d("LoginFragment","Login...")
            findNavController().navigate(R.id.action_loginFragment_to_timeLineFragment)
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
        val PASSWORD_PATTERN: Pattern = Pattern.compile("[a-zA-Z0-9]{5,24}")
        val pass:String = text.text.toString()
        return pass.isNotEmpty() && PASSWORD_PATTERN.matcher(pass).matches()
    }
}