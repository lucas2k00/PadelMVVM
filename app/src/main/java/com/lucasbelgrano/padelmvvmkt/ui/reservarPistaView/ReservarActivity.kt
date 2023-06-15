package com.lucasbelgrano.padelmvvmkt.ui.reservarPistaView

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucasbelgrano.padelmvvmkt.data.database.ClubDatabaseSQLiteOpenHelper
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityReservarBinding
import com.lucasbelgrano.padelmvvmkt.ui.menuView.MainActivity
import java.util.Calendar

class ReservarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReservarBinding
    private lateinit var clubDBHelper: ClubDatabaseSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReservarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra("username")
        val calendar = Calendar.getInstance()
        val listenerFecha = DatePickerDialog.OnDateSetListener { _, anio, mes, dia ->
            val listenerHora = TimePickerDialog.OnTimeSetListener { _, hora, minuto ->
                clubDBHelper.reservarPista(username!!, "$anio-$mes-$dia", "$hora:$minuto:00")
                Toast.makeText(this, "Pista reservada", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, MainActivity::class.java))
            }

            TimePickerDialog(
                this, listenerHora,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE), true
            ).show()
        }

        DatePickerDialog(
            this,
            listenerFecha,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH),
        ).show()
    }
}