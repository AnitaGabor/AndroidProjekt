package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.Product
import com.example.marketplace.models.ProductResponse
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository) : ViewModel() {
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var currentPosition:Int = 0;
    init{
        Log.d("xxx", "ListViewModel constructor - Token: ${MyApplication.token}")
        getProducts()
    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                val result =
                    repository.getProducts(MyApplication.token)
                products.value = result.products
                Log.d("ListViewModel", "ListViewModel - #products:  ${result.item_count}")
            }catch(e: Exception){
                Log.d("ListViewModel", "ListViewModel exception: ${e.toString()}")
            }
        }
    }
}