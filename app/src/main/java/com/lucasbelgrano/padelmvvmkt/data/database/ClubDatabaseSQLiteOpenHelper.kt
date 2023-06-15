package com.lucasbelgrano.padelmvvmkt.data.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ClubDatabaseSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(
    context, "clubPadel.db", null, 1
) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE users " + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)")
        db.execSQL("CREATE TABLE pistasPadel" + "(id INTEGER PRIMARY KEY)")
        db.execSQL("CREATE TABLE reservas (id INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, id_pista INTEGER, fecha_reserva DATE, hora_inicio TIME, hora_fin TIME, FOREIGN KEY (id_usuario) REFERENCES users(id), FOREIGN KEY (id_pista) REFERENCES pistasPadel(id))")
        for (i in 0..3) { // Insertar las pistas de pádel
            db.execSQL("INSERT INTO pistasPadel (id) VALUES ($i)")
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun aniadirUsuario(name: String, password: String): Boolean {
        val datos = ContentValues()
        datos.put("name", name)
        datos.put("password", password)
        val db = this.writableDatabase
        //comprobar si name user existe en la bbdd
        val cursos = db.query("users", null, "name = ?", arrayOf(name), null, null, null)
        return if (cursos.count > 0) {
            cursos.close()
            db.close()
            false
        } else {
            db.insert("users", null, datos)
            cursos.close()
            db.close()
            true
        }
    }
    fun comprobarCredenciales(name: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery(
            "SELECT * FROM users WHERE name = ? AND password = ?",
            arrayOf(name, password)
        )
        val res = cursor.count > 0
        cursor.close()
        db.close()

        return res
    }
    fun reservarPista(username: String, fecha: String, horaIni: String) {
        val horaFin = sumarHoras(horaIni, 2)
        val datos = ContentValues()
        datos.put("id_usuario", getUserId(username))
        datos.put("id_pista", 0)
        datos.put("fecha_reserva", fecha)
        datos.put("hora_inicio", horaIni)
        datos.put("hora_fin", horaFin)
        val db = this.writableDatabase
        db.insert("reservas", null, datos)
        db.close()
    }
    fun getReservarByUser (username: String): String {
        val idUser: Int = getUserId(username)
        val db = this.readableDatabase
        val cursos = db.rawQuery("SELECT * FROM reservas WHERE id_usuario = $idUser", null)
        if (cursos.count > 0) {
            cursos.close()
            db.close()

            return "Tienes ${cursos.count} pistas reservadas"
        }
        cursos.close()
        db.close()

        return "No tienes ninguna pista reservada"
    }

    private fun getUserId(username: String): Int {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE name = ?", arrayOf(username))
        var id = -1
        if (cursor.moveToFirst()) {
            id = cursor.getInt(0)
        }
        cursor.close()
        db.close()

        return id
    }
    private fun sumarHoras(hora: String, cantidadHoras: Int): String {
        val formatoHora = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        val calendar = Calendar.getInstance()
        calendar.time = formatoHora.parse(hora)!!
        calendar.add(Calendar.HOUR_OF_DAY, cantidadHoras)

        return formatoHora.format(calendar.time)
    }
}