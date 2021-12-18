package com.example.marketplace.login


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.model.*
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class LoginViewModel (val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }
    suspend fun login() {
        viewModelScope.launch {
            val request = LoginRequest(username = user.value!!.username, password = user.value!!.password)
            try {
                val result = repository.login(request)
                MyApplication.token = result.token
                MyApplication.username = result.username
                token.value = result.token
                Log.d("LoginViewModel ok", "LoginViewModel - #users:  ${MyApplication.token}")
            }catch(e: Exception){

                Log.d("LoginViewModel fail", "LoginViewModel exception login: ${e.toString()}")
            }
        }
    }



}