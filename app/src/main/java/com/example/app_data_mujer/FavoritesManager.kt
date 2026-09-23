package com.example.app_data_mujer

import androidx.compose.runtime.mutableStateListOf

object FavoritesManager {
    val favoriteScientists = mutableStateListOf<String>()

    fun toggleFavorite(name: String) {
        if (favoriteScientists.contains(name)) {
            favoriteScientists.remove(name)
        } else {
            favoriteScientists.add(name)
        }
    }

    fun isFavorite(name: String): Boolean {
        return favoriteScientists.contains(name)
    }
}
