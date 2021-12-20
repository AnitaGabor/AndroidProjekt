package com.example.marketplace.register.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.models.model.*
import com.example.marketplace.register.model.RegisterRequest
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
                Log.d("RegisterViewModel ok", "RegisterViewModel - #users:  ${result.code}")
            }catch(e: Exception){

                Log.d("RegisterViewModel fail", "RegisterViewModel exception: ${e.toString()}")
            }
        }
    }
}