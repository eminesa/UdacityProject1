package com.eminesa.udacityproject1.helper


import android.content.Context
import android.content.SharedPreferences
import com.eminesa.udacityproject1.R

class CacheHelper(context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(context.getString(R.string.app_name), Context.MODE_PRIVATE)

    companion object {
        const val USER_NAME = "user_name"
        const val USER_PASSWORD = "user_password"
    }

    fun saveUserName(name: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_NAME, name)
        editor.apply()
    }
    fun saveUserPassword(password: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_PASSWORD, password)
        editor.apply()
    }

    fun fetchUserName(): String? {
        return sharedPreferences.getString(USER_NAME, null)
    }

    fun fetchUserPassword(): String? {
        return sharedPreferences.getString(USER_PASSWORD, null)
    }

    fun clearLogin() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}