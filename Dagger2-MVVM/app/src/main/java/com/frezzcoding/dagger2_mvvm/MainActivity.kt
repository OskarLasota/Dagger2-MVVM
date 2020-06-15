package com.frezzcoding.dagger2_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.frezzcoding.dagger2_mvvm.components.DaggerProductComponent
import com.frezzcoding.dagger2_mvvm.models.Product
import com.frezzcoding.dagger2_mvvm.vm.ProductsViewModel
import com.frezzcoding.dagger2_mvvm.vm.ViewModelFactory
import javax.inject.Inject

open class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel : ProductsViewModel
    @Inject
    lateinit var viewModelFactory : ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerProductComponent.builder().build().inject(this)

        initViewModels()
        initObservers()

        viewModel.getProducts()
    }

    private fun initViewModels() {
        viewModel = ViewModelProvider(this, viewModelFactory).get(
            ProductsViewModel::class.java)
    }

    private fun initObservers(){
        viewModel.isViewLoading.observe(this, observeLoading)
        viewModel.products.observe(this, observeProducts)
    }

    private val observeLoading = Observer<Boolean>{
        println(it)
    }

    private val observeProducts = Observer <ArrayList<Product>>{
        for(elem in it){
            println(elem.id)
        }
    }

}