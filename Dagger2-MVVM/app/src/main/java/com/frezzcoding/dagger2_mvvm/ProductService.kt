package com.frezzcoding.dagger2_mvvm

import com.frezzcoding.dagger2_mvvm.models.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products.php")
    fun products(): Call<ArrayList<Product>>

}