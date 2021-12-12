package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.SettingsRequest
import com.example.marketplace.models.User
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class SettingsViewModel (val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }
    suspend fun updateUser() {
        viewModelScope.launch {
            val request = SettingsRequest(username = user.value!!.username, email = user.value!!.email, phone_number = user.value!!.phone_number)
            try {
                val result = repository.updateUser(MyApplication.token,request)
                MyApplication.token = result.updateData.token
                token.value = result.updateData.token
                Log.d("SettingsViewModel ok", "SettingsViewModel - #users:  ${MyApplication.token}")
            }catch(e: Exception){

                Log.d("SettingsViewModel fail", "SettingsViewModel exception: ${e.toString()}")
            }
        }
    }
}