package com.lucasbelgrano.padelmvvmkt.ui.menuView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasbelgrano.padelmvvmkt.R
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityGolpesBinding
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityMainBinding
import com.lucasbelgrano.padelmvvmkt.ui.aboutUsView.AboutUsActivity
import com.lucasbelgrano.padelmvvmkt.ui.golpesView.GolpesActivity
import com.lucasbelgrano.padelmvvmkt.ui.reservarPistaView.ReservarActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val parametro = intent.getStringExtra("nameUser")
        binding.txtSaludo.text = binding.txtSaludo.text.toString() + intent.getStringExtra("nameUser")
        binding.btnAboutUs.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }
        binding.btnReservar.setOnClickListener {
            startActivity(Intent(this, ReservarActivity::class.java))
        }
        binding.btnGolpes.setOnClickListener {
            startActivity(Intent(this, GolpesActivity::class.java))
        }
    }
}