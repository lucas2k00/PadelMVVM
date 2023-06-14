package com.lucasbelgrano.padelmvvmkt.ui.golpesView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityMainBinding

class GolpesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val golpesViewModel: GolpesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Logica al seguir en caso de actualizar liveData
        golpesViewModel.golpesModel.observe(this, Observer { currentGolpe ->
            //Actualiza livedata, test git
            binding.tvName.text = currentGolpe.name
            binding.tvDescription.text = currentGolpe.description
        })
        binding.viewContainer.setOnClickListener { golpesViewModel.nextGolpe() }
    }
}