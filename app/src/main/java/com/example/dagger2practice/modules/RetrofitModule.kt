package com.example.dagger2practice.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class RetrofitModule {

    private val API_BASE_URL = "http://bolosassuncao.com.br/api/"

    @Singleton
    @Provides
    fun providesGsonConverterFactory() : GsonConverterFactory {
        return GsonConverterFactory.create(Gson())
    }

    @Singleton
    @Provides
    fun providesConfigurationRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}