package com.lucasbelgrano.padelmvvmkt.ui.loginView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucasbelgrano.padelmvvmkt.data.database.ClubDatabaseSQLiteOpenHelper
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var clubDBHelper: ClubDatabaseSQLiteOpenHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        clubDBHelper = ClubDatabaseSQLiteOpenHelper(this)

        binding.btnLogin.setOnClickListener {
            if (binding.editTextUsername.text.isNotBlank() &&
                binding.editTextPassword.text.isNotBlank()
            ) {
                if (clubDBHelper.comprobarCredenciales(
                    binding.editTextUsername.text.toString(),
                    binding.editTextPassword.text.toString()
                )) {
                    Toast.makeText(this, "Usuario valido", Toast.LENGTH_SHORT)
                    //Cambiar vista
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT)
                }
            } else {
                Toast.makeText(this, "Rellena el formulario", Toast.LENGTH_SHORT)
            }
        }

        binding.btnRegister.setOnClickListener{
            if (binding.editTextUsername.text.isNotBlank() &&
                binding.editTextPassword.text.isNotBlank()
            ) {
                if (clubDBHelper.aniadirUsuario(
                        binding.editTextUsername.text.toString(),
                        binding.editTextPassword.text.toString()
                    )) {
                    Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT)
                    //Cambiar vista
                } else {
                    Toast.makeText(this, "Nombre de usuario ya existe", Toast.LENGTH_SHORT)
                }
            } else {
                Toast.makeText(this, "Rellena el formulario", Toast.LENGTH_SHORT)
            }
        }
    }
}