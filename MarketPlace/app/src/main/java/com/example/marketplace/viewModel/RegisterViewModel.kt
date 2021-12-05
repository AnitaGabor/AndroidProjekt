package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.LoginRequest
import com.example.marketplace.models.RegisterRequest
import com.example.marketplace.models.User
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class RegisterViewModel (val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }
    suspend fun register() {
        viewModelScope.launch {
            val request = RegisterRequest(username = user.value!!.username, password = user.value!!.password, email = user.value!!.email)
            try {
                val result = repository.register(request)
                MyApplication.token = result.message
                token.value = result.message
                Log.d("RegisterViewModel ok", "RegisterViewModel - #users:  ${MyApplication.token}")
            }catch(e: Exception){

                Log.d("RegisterViewModel fail", "RegisterViewModel exception: ${e.toString()}")
            }
        }
    }
}