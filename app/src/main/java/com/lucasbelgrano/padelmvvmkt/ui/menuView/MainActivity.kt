package com.lucasbelgrano.padelmvvmkt.ui.menuView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasbelgrano.padelmvvmkt.data.database.ClubDatabaseSQLiteOpenHelper
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityMainBinding
import com.lucasbelgrano.padelmvvmkt.ui.aboutUsView.AboutUsActivity
import com.lucasbelgrano.padelmvvmkt.ui.golpesView.GolpesActivity
import com.lucasbelgrano.padelmvvmkt.ui.reservarPistaView.ReservarActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var clubDBHelper: ClubDatabaseSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clubDBHelper = ClubDatabaseSQLiteOpenHelper(this)
        val username = intent.getStringExtra("username").toString()

        binding.txtSaludo.text =
            binding.txtSaludo.text.toString() + username
        //binding.txtReserva.text = clubDBHelper.getReservarByUser(username)

        binding.btnAboutUs.setOnClickListener {
            startActivity(Intent(this, AboutUsActivity::class.java))
        }
        binding.btnReservar.setOnClickListener {
            val intent = Intent(this, ReservarActivity::class.java)
            intent.putExtra("username", username)
            startActivity(intent)
        }
        binding.btnGolpes.setOnClickListener {
            startActivity(Intent(this, GolpesActivity::class.java))
        }
    }
}