package com.example.dagger2practice

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/*
TODO : Should be generic
 */

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(var repository : ProductRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(repository) as T
    }

}