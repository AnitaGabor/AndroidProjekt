package com.example.marketplace.settingsProfile.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.model.*
import com.example.marketplace.repository.Repository
import com.example.marketplace.settingsProfile.model.SettingsRequest
import kotlinx.coroutines.launch

class SettingsViewModel(val repository: Repository) : ViewModel() {
    var token: MutableLiveData<String> = MutableLiveData()
    var user = MutableLiveData<User>()

    init {
        user.value = User()
    }

    fun updateUser() {
        viewModelScope.launch {
            val request = SettingsRequest(
                username = user.value!!.username,
                email = user.value!!.email,
                phone_number = user.value!!.phone_number
            )
            try {
                val result = repository.updateUser(MyApplication.token, request)
                Log.d("SettingsViewModel ok", "SettingsViewModel - #users:  $result")
            } catch (e: Exception) {

                Log.d("SettingsViewModel fail", "SettingsViewModel exception: ${e.toString()}")
            }
        }
    }
}