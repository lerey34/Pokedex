package com.example.pokedex.data

import android.content.Context

class PreferenceManager(context: Context) {
    private val PREF_NAME = "my_pref"
    private val KEY_RESULT = "api_result"

    val sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveResult(result: String) {
        val editor = sharedPreferences.edit()
        editor.putString(KEY_RESULT, result)
        editor.apply()
    }

    fun getResult(): String? {
        return sharedPreferences.getString(KEY_RESULT, null)
    }
}