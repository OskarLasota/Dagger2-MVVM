package com.frezzcoding.dagger2_mvvm.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.frezzcoding.dagger2_mvvm.models.Product
import com.frezzcoding.dagger2_mvvm.repo.ProductRepository
import com.frezzcoding.dagger2_mvvm.utils.OperationCallBack
import javax.inject.Inject

class ProductsViewModel @Inject constructor(
    var repository : ProductRepository
) :
    ViewModel() {

    private val _products = MutableLiveData<ArrayList<Product>>()
    val products : LiveData<ArrayList<Product>> = _products

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading:LiveData<Boolean> = _isViewLoading



    fun getProducts(){
        _isViewLoading.postValue(true)
        repository.getProducts(object :
            OperationCallBack<Product> {
            override fun onSuccess(data: ArrayList<Product>) {
                _products.value = data
                _isViewLoading.postValue(false)
            }

            override fun onError(error: String?) {
                println(error)
                _isViewLoading.postValue(false)
            }


        })


    }


}