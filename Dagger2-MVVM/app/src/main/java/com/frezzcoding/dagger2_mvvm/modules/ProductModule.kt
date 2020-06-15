package com.example.dagger2practice.modules

import com.frezzcoding.dagger2_mvvm.ProductService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [RetrofitModule::class])
class ProductModule {

    @Singleton
    @Provides
    fun provideProductService(retrofit : Retrofit) = retrofit.create(ProductService::class.java)


}