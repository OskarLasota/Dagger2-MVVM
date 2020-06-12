package com.example.dagger2practice

import androidx.lifecycle.LiveData
import com.example.dagger2practice.models.Product
import com.example.dagger2practice.utils.OperationCallBack
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(MockitoJUnitRunner::class)
class ExampleUnitTest {



    lateinit var viewModel : ProductsViewModel

    @Mock
    lateinit var callback : OperationCallBack<Product>

    @Mock
    lateinit var service : ProductService

    lateinit var repo : ProductRepository




    @Before
    fun setUp(){
        repo = ProductRepository(service)
        viewModel = ProductsViewModel(repo)
    }

    @Test
    fun `on obtaining products, is service called`(){
        viewModel.getProducts()
        verify(service, atLeastOnce()).products()
    }

    @Test
    fun `on obtaining products, loading is true`() {
        viewModel.getProducts()
        println(viewModel.isViewLoading.value)
        assert(viewModel.isViewLoading.value!!)
    }



}