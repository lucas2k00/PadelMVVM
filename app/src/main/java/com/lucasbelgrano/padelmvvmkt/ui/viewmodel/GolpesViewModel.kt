package com.lucasbelgrano.padelmvvmkt.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasbelgrano.padelmvvmkt.data.model.GolpesModel
import com.lucasbelgrano.padelmvvmkt.data.model.GolpesProvider

class GolpesViewModel : ViewModel() {

    val golpesModel = MutableLiveData<GolpesModel>()

    fun nextGolpe() {
        golpesModel.postValue(GolpesProvider.next())
    }
}