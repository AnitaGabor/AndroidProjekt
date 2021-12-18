package com.example.marketplace

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    var username:String ="";

    fun setName( name:String)
    {
        username = name
    }

    fun getName() : String
    {
        return username
    }
}