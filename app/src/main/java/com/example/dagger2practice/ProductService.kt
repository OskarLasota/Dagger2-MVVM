package com.example.dagger2practice

import com.example.dagger2practice.models.Product
import retrofit2.Call
import retrofit2.http.GET

interface ProductService {

    @GET("products.php")
    fun products(): Call<ArrayList<Product>>

}