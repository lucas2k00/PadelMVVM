package com.lucasbelgrano.padelmvvmkt.ui.loginView

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.lucasbelgrano.padelmvvmkt.data.database.ClubDatabaseSQLiteOpenHelper
import com.lucasbelgrano.padelmvvmkt.databinding.ActivityLoginBinding
import com.lucasbelgrano.padelmvvmkt.ui.menuView.MainActivity

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
                    Toast.makeText(this, "Usuario valido", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", binding.editTextUsername.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Usuario o contraseña incorrecta", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Rellena el formulario", Toast.LENGTH_LONG).show()
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
                    Toast.makeText(this, "Usuario creado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("username", binding.editTextUsername.text.toString())
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Nombre de usuario ya existe", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this, "Rellena el formulario", Toast.LENGTH_LONG).show()
            }
        }
    }
}