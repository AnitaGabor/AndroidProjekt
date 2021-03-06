package com.example.marketplace.forgetPassword.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.forgetPassword.model.ResetRequest
import com.example.marketplace.models.model.*
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
                Log.d("ResetViewModel ok", "ResetViewModel - #users:  ${result.code}")
            }catch(e: Exception){

                Log.d("ResetViewModel fail", "ResetViewModel exception: ${e.toString()}")
            }
        }
    }
}