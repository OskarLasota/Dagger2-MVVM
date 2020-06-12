package com.example.dagger2practice.components


import com.example.dagger2practice.MainActivity
import com.example.dagger2practice.modules.ProductModule
import com.example.dagger2practice.modules.RetrofitModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ProductModule::class, RetrofitModule::class])
interface ProductComponent {
    fun inject(app: MainActivity)
}