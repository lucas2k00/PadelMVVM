package com.lucasbelgrano.padelmvvmkt.ui.reservarPistaView

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucasbelgrano.padelmvvmkt.R
import com.lucasbelgrano.padelmvvmkt.ui.menuView.MainActivity
import java.util.Calendar
import java.util.Date

class ReservarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reservar)

        val calendar = Calendar.getInstance()
        val listenerFecha = DatePickerDialog.OnDateSetListener { datePicker, anio, mes, dia ->
            val listenerHora = TimePickerDialog.OnTimeSetListener { hourPicker, hora, minuto ->
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("reserva", "Tienes una pista reservada el día $dia de $mes de $anio a las $hora:$minuto. ¡Nos vemos allí!")
                startActivity(intent)
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
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }
}