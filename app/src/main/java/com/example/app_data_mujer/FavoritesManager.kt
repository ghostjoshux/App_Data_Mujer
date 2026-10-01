package com.example.app_data_mujer

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateListOf

object FavoritesManager {
    val favoriteScientists = mutableStateListOf<String>()
    private var prefs: SharedPreferences? = null

    fun init(context: Context) {
        if (prefs == null) {
            val p = context.applicationContext.getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
            prefs = p
            val savedSet = p.getStringSet("favorite_scientists", emptySet()) ?: emptySet()
            favoriteScientists.clear()
            favoriteScientists.addAll(savedSet)
        }
    }

    fun toggleFavorite(name: String) {
        if (favoriteScientists.contains(name)) {
            favoriteScientists.remove(name)
        } else {
            favoriteScientists.add(name)
        }
        save()
    }

    fun isFavorite(name: String): Boolean {
        return favoriteScientists.contains(name)
    }

    private fun save() {
        prefs?.edit()?.putStringSet("favorite_scientists", favoriteScientists.toSet())?.apply()
    }
}
