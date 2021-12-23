package com.example.marketplace.timeline.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.timeline.model.Product
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository) : ViewModel() {
    var products: MutableLiveData<List<Product>> = MutableLiveData()
    var currentPosition:Int = 0;
    var deleteId: MutableLiveData<String> = MutableLiveData()
    init{
        Log.d("ListViewModel", "ListViewModel constructor - Token: ${MyApplication.token}")

    }

    fun getProducts() {
        viewModelScope.launch {
            try {
                val result = repository.getProducts(MyApplication.token, MyApplication.limit)
                products.value = result.products
                Log.d("ListViewModel", "ListViewModel - #products:  ${result.item_count}")
            }catch(e: Exception){
                Log.d("ListViewModel", "ListViewModel exception: ${e.toString()}")
            }
        }
    }

    fun getProduct() :Product{
        return products.value!![currentPosition]
    }

    fun removeProduct(){
        viewModelScope.launch {
            try {
                Log.d("xxx","${products.value!![currentPosition].product_id}")
                val result = repository.removeProduct(MyApplication.token, products.value!![currentPosition].product_id)
                deleteId.value = result.product_id
                Log.d("ListViewModel", "ListViewModel - #delete:  ${result.product_id}")
            }catch(e: Exception){
                Log.d("ListViewModel", "ListViewModel exception delete: ${e.toString()}")
            }
        }
    }
}