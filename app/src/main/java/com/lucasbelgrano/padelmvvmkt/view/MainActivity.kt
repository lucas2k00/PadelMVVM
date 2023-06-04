package com.lucasbelgrano.padelmvvmkt.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityMainBinding
import com.lucasbelgrano.padelmvvmkt.viewmodel.GolpesViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val golpesViewModel: GolpesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        golpesViewModel.golpesModel.observe(this, Observer { currentGolpe ->
            //Actualiza livedata, test git
            binding.tvName.text = currentGolpe.name
            binding.tvDescription.text = currentGolpe.description
        })
        binding.viewContainer.setOnClickListener { golpesViewModel.randomGolpe() }
    }
}