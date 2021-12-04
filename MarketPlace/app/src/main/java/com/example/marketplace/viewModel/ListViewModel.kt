package com.example.marketplace.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marketplace.MyApplication
import com.example.marketplace.models.ProductResponse
import com.example.marketplace.repository.Repository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: Repository) : ViewModel() {
    var currentPosition: Int = 0
    val products: MutableLiveData<ProductResponse> = MutableLiveData()
    init{

        getPost()
    }

    fun getPost()
    {
        viewModelScope.launch {
            try {
                val result = repository.getPost(MyApplication.token)
                products.value = result
                Log.d("ListViwemodel ok", "ListViewModel - #products:  ${result.item_count}")
            }catch(e: Exception){
                Log.d("ListViewModel fail", "ListViewModel exception: ${e.toString()}")
            }
        }
    }
}