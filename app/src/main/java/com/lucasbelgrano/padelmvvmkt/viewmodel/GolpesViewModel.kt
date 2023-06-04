package com.lucasbelgrano.padelmvvmkt.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasbelgrano.padelmvvmkt.model.GolpesModel
import com.lucasbelgrano.padelmvvmkt.model.GolpesProvider

class GolpesViewModel : ViewModel() {

    val golpesModel = MutableLiveData<GolpesModel>()

    fun randomGolpe() {
        golpesModel.postValue(GolpesProvider.random())
    }
}