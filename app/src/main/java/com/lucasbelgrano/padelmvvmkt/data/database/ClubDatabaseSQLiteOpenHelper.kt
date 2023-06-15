package com.lucasbelgrano.padelmvvmkt.data.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ClubDatabaseSQLiteOpenHelper(context: Context) : SQLiteOpenHelper(
    context, "clubPadel.db", null, 1
) {

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE users " + "(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, password TEXT)")
        db!!.execSQL("CREATE TABLE pistasPadel" + "(id INTEGER PRIMARY KEY)")
        db!!.execSQL("CREATE TABLE reservas (id INTEGER PRIMARY KEY AUTOINCREMENT, id_usuario INTEGER, id_pista INTEGER, fecha_reserva DATE, hora_inicio TIME, hora_fin TIME, FOREIGN KEY (id_usuario) REFERENCES users(id), FOREIGN KEY (id_pista) REFERENCES pistasPadel(id))")

        // Insertar las pistas de pádel
        for (i in 0..3) {
            db!!.execSQL("INSERT INTO pistasPadel (id) VALUES ($i)")
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
        if (cursos.count > 0) {
            cursos.close()
            db.close()
            return false
        } else {
            db.insert("users", null, datos)
            cursos.close()
            db.close()
            return true
        }
    }

    fun comprobarCredenciales(name: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM users WHERE name = ? AND password = ?", arrayOf(name, password))
        val res = cursor.count > 0
        cursor.close()
        db.close()

        return res
    }
}