package com.example.marketplace.viewModel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    private var name:String =""
    private var email:String =""
    private var phone:String=""
    private var username:String=""

    fun setName(parameter :String)
    {
       name = parameter
    }

    fun setEmail(parameter :String)
    {
        email = parameter
    }
    fun setPhone(parameter :String)
    {
        phone = parameter
    }
    fun setUserName(parameter:String)
    {
        username = parameter
    }

    fun getEmail(): String {
        return email
    }

    fun getPhone():String{
        return phone
    }

    fun getUserName():String{
        return username
    }


}