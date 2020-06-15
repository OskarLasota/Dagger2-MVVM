package com.frezzcoding.dagger2_mvvm

import com.frezzcoding.dagger2_mvvm.models.Product
import com.frezzcoding.dagger2_mvvm.repo.ProductRepository
import com.frezzcoding.dagger2_mvvm.utils.OperationCallBack
import com.frezzcoding.dagger2_mvvm.vm.ProductsViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
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
        Mockito.verify(service, Mockito.atLeastOnce()).products()
    }

    @Test
    fun `on obtaining products, loading is true`() {
        viewModel.getProducts()
        println(viewModel.isViewLoading.value)
        assert(viewModel.isViewLoading.value!!)
    }



}