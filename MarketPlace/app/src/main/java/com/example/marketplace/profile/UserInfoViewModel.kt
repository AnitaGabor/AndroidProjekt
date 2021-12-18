package com.example.marketplace.profile


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.model.*
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class UserInfoViewModel (private val repository: Repository) : ViewModel()
{
    val user: MutableLiveData<User> = MutableLiveData()
    init {

        getUserData()
    }

    private fun getUserData() {
        viewModelScope.launch {
            try {
                val result = repository.getUserData(MyApplication.username)
                user.value = result.data
                Log.d("UserInfoViwemodel ok", "UserInfoViewModel - #products:  ${result.code}")
            } catch (e: Exception) {
                Log.d("UserInfoViewModel fail", "UserInfoViewModel exception: ${e.toString()}")
            }
        }
    }
}