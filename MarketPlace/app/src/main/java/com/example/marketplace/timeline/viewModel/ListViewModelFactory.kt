package com.example.marketplace.timeline.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.Factory
import com.example.marketplace.repository.Repository

class ListViewModelFactory(private val repository: Repository) : Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ListViewModel(repository) as T
    }
}