package com.example.marketplace.addproduct.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.model.User
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import kotlinx.coroutines.launch

class AddViewModel(val repository: Repository) : ViewModel() {
    var product = MutableLiveData<Product>()

    init {
        product.value = Product()
    }

    fun addProduct() {
        viewModelScope.launch {
            try {
                val result = repository.addProduct(MyApplication.token,
                title = product.value!!.title,
                description = product.value!!.description,
                price_per_unit = product.value!!.price_per_unit,
                units = product.value!!.units)
                Log.d(
                    "AddProductViewModel ok",
                    "AddProductViewModel - #new product:  ${result.creation}"
                )
            } catch (e: Exception) {

                Log.d("AddProductViewModel fail", "AddProductViewModel exception: ${e.toString()}")
            }
        }
    }
}