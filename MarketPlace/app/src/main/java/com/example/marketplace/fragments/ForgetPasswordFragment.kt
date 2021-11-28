package com.example.marketplace.fragments

import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.marketplace.R

class ForgetPasswordFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_forget_password, container, false)

        val email = view.findViewById<EditText>(R.id.editTextTextEmailAddress2)

        val button = view.findViewById<Button>(R.id.passwordButton)

        button.setOnClickListener {
            if(!isEmail(email))
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Enter valid email!", Toast.LENGTH_SHORT)
                t.show()
            }
            else
            {
                val t: Toast = Toast.makeText(activity?.applicationContext,"Email sent!", Toast.LENGTH_SHORT)
                t.show()
            }
        }
        return view
    }

    fun isEmail(text: EditText): Boolean {
        val email: String = text.text.toString()
        return !email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

}