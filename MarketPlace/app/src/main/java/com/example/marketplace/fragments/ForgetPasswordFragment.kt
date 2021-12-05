package com.example.marketplace.fragments

import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.marketplace.R
import com.example.marketplace.repository.Repository
import com.example.marketplace.viewModel.RegisterViewModel
import com.example.marketplace.viewModel.RegisterViewModelFactory
import com.example.marketplace.viewModel.ResetViewModel
import com.example.marketplace.viewModel.ResetViewModelFactory
import kotlinx.coroutines.launch

class ForgetPasswordFragment : Fragment() {
    private lateinit var resetViewModel: ResetViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val factory = ResetViewModelFactory(Repository())
        resetViewModel = ViewModelProvider(this, factory).get(ResetViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_forget_password, container, false)

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress2)
        val username = view.findViewById<EditText>(R.id.editTextTextNameReset)
        val button = view.findViewById<Button>(R.id.passwordButton)

        button.setOnClickListener {
            if(!isEmail(email))
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Enter valid email!", Toast.LENGTH_SHORT)
                t.show()
            }
            else if(isEmpty(username.text.toString()) || username.text.toString() == "Username")
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Enter username!", Toast.LENGTH_SHORT)
                t.show()
            }
            else
            {
                resetViewModel.user.value.let {
                    if (it != null) {
                        it.username = username.text.toString()
                    }
                    if(it!=null){
                        it.email = email.text.toString()
                    }
                }
                lifecycleScope.launch {
                    resetViewModel.reset()
                }

            }
        }
        resetViewModel.token.observe(viewLifecycleOwner){
            val t: Toast = Toast.makeText(activity?.applicationContext,"Success!", Toast.LENGTH_SHORT)
            t.show()
            this.findNavController().navigate(R.id.action_forgetPasswordFragment_to_loginFragment)
        }
        return view
    }

    fun isEmail(text: EditText): Boolean {
        val email: String = text.text.toString()
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}