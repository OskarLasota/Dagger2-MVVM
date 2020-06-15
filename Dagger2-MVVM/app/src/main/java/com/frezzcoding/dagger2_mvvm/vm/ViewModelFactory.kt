package com.frezzcoding.dagger2_mvvm.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


/*
todo: should be generic
 */



@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor(var repository : ProductRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductsViewModel(repository) as T
    }

}