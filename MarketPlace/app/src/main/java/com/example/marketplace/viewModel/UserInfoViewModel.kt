package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.ProductResponse
import com.example.marketplace.models.UserResponse
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class UserInfoViewModel (private val repository: Repository) : ViewModel()
{
    val user: MutableLiveData<UserResponse> = MutableLiveData()
    init {

        getUserData()
    }

    fun getUserData() {
        viewModelScope.launch {
            try {
                val result = repository.getUserData(MyApplication.token)
                user.value = result
                Log.d("UserInfoViwemodel ok", "UserInfoViewModel - #products:  ${result.code}")
            } catch (e: Exception) {
                Log.d("UserInfoViewModel fail", "UserInfoViewModel exception: ${e.toString()}")
            }
        }
    }
}