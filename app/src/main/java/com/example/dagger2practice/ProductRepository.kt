package com.example.dagger2practice

import com.example.dagger2practice.models.Product
import com.example.dagger2practice.utils.OperationCallBack
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