package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.RegisterRequest
import com.example.marketplace.models.ResetRequest
import com.example.marketplace.models.User
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class ResetViewModel (val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }
    suspend fun reset() {
        viewModelScope.launch {
            val request = ResetRequest(username = user.value!!.username, email = user.value!!.email)
            try {
                val result = repository.reset(request)
                MyApplication.token = result.message
                token.value = result.message
                Log.d("ResetViewModel ok", "ResetViewModel - #users:  ${MyApplication.token}")
            }catch(e: Exception){

                Log.d("ResetViewModel fail", "ResetViewModel exception: ${e.toString()}")
            }
        }
    }
}