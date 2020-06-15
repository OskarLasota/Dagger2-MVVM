package com.frezzcoding.dagger2_mvvm.repo


import com.frezzcoding.dagger2_mvvm.ProductService
import com.frezzcoding.dagger2_mvvm.models.Product
import com.frezzcoding.dagger2_mvvm.utils.OperationCallBack
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class ProductRepository @Inject constructor(var service : ProductService) {

    private var call: Call<ArrayList<Product>> ?= null

    fun getProducts(callback : OperationCallBack<Product>) {
        call= service.products()
        call?.enqueue(object: Callback<ArrayList<Product>>{
            override fun onFailure(call: Call<ArrayList<Product>>, t: Throwable) {
                callback.onError(t.message)
            }

            override fun onResponse(
                call: Call<ArrayList<Product>>?,
                response: Response<ArrayList<Product>>?
            ) {
                response?.body()?.let {
                    if(response.isSuccessful){
                        callback.onSuccess(it)
                    }
                }
            }

        })

    }

}