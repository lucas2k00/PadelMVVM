package com.lucasbelgrano.padelmvvmkt.ui.golpesView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityGolpesBinding

class GolpesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGolpesBinding
    private val golpesViewModel: GolpesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGolpesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        golpesViewModel.golpesModel.observe(this, Observer { currentGolpe ->
            binding.tvName.text = currentGolpe.name
            binding.tvDescription.text = currentGolpe.description
        })
        binding.viewContainer.setOnClickListener { golpesViewModel.nextGolpe() }
    }
}