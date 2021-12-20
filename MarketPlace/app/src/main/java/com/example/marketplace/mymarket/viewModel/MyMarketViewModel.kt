package com.example.marketplace.mymarket.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.repository.Repository
import com.example.marketplace.timeline.model.Product
import kotlinx.coroutines.launch

class MyMarketViewModel (private val repository: Repository) : ViewModel() {
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var currentPosition: Int = 0;

    init {
        Log.d("MyMarketViewModel", "MyMarketViewModel constructor - Token: ${MyApplication.token}")
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts(MyApplication.token, MyApplication.limit)
                for( product:Product in result.products){
                    if(product.username == MyApplication.username){
                        products.value!!.plus(product)
                    }
                }
                Log.d("MyMarketViewModel", "MyMarketViewModel - #products:  ${result.item_count}")
            } catch (e: Exception) {
                Log.d("MyMarketViewModel", "MyMarketViewModel exception: ${e.toString()}")
            }
        }
    }
}