package com.example.marketplace.addproduct.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.addproduct.model.AddProductRequest
import com.example.marketplace.models.model.User
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import kotlinx.coroutines.launch

class AddViewModel(val repository: Repository) : ViewModel() {
    var product = MutableLiveData<Product>()
    var user = MutableLiveData<User>()

    init {
        product.value = Product()
        user.value = User()
    }
    suspend fun addProduct() {
        viewModelScope.launch {
            val request = AddProductRequest( title = product.value!!.title, price_per_unit = product.value!!.price_per_unit, units = product.value!!.units,
            description = product.value!!.description, username = user.value!!.username, email = user.value!!.email, phone_number = user.value!!.phone_number)
            try {
                val result = repository.addProduct(MyApplication.token,request)
                Log.d("AddProductViewModel ok", "AddProductViewModel - #new product:  ${result.creation}")
            }catch(e: Exception){

                Log.d("AddProductViewModel fail", "AddProductViewModel exception: ${e.toString()}")
            }
        }
    }
}