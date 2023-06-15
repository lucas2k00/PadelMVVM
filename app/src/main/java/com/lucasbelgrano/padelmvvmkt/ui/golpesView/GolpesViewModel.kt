package com.lucasbelgrano.padelmvvmkt.ui.golpesView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasbelgrano.padelmvvmkt.data.model.golpes.GolpesModel
import com.lucasbelgrano.padelmvvmkt.data.model.golpes.GolpesProvider

class GolpesViewModel : ViewModel() {
    val golpesModel = MutableLiveData<GolpesModel>()
    fun nextGolpe() {
        golpesModel.postValue(GolpesProvider.next())
    }
}