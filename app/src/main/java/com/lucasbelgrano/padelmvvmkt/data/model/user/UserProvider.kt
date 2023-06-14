package com.lucasbelgrano.padelmvvmkt.data.model.user

class UserProvider {
    private val users = arrayListOf<UserModel>(UserModel("user", "user"))
    fun addUser(u: UserModel) {
        users.add(u)
    }
    fun validateUser(u: String, p: String): Boolean {
        for (userModel in users) {
            if (userModel.user == u && userModel.password == p) {
                return true
            }
        }
        return false
    }
}