package com.frezzcoding.dagger2_mvvm.components

import com.example.dagger2practice.modules.ProductModule
import com.example.dagger2practice.modules.RetrofitModule
import com.frezzcoding.dagger2_mvvm.MainActivity
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ProductModule::class, RetrofitModule::class])
interface ProductComponent {
    fun inject(app: MainActivity)
}