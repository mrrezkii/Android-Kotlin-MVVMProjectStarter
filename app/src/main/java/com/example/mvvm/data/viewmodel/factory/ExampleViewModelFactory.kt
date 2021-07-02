package com.example.mvvm.data.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.viewmodel.ExampleViewModel
import com.example.mvvm.network.ExampleRepository

class ExampleViewModelFactory(
    private val repository: ExampleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ExampleViewModel(repository) as T
    }
}