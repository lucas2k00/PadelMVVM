package com.lucasbelgrano.padelmvvmkt.ui.loginView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val loginResult: MutableLiveData<Boolean> = MutableLiveData()

    fun login(user: String, password: String) {
        // Aquí puedes implementar la lógica de autenticación
        // Verifica si el usuario y la contraseña son válidos
        val isValid = isValidCredentials(user, password)
        loginResult.value = isValid
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Aquí puedes implementar la validación de credenciales según tus requisitos
        return username == "usuario" && password == "contraseña"
    }
}