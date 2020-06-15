package com.frezzcoding.dagger2_mvvm.utils

interface OperationCallBack<T> {

    //onsuccess needs to be made generic somehow
    fun onSuccess(data: ArrayList<T>)
    fun onError(error:String?)
}