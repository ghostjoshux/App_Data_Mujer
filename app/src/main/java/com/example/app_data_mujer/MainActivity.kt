package com.example.app_data_mujer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.app_data_mujer.ui.theme.App_Data_MujerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sharedPrefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
        val savedUsername = sharedPrefs.getString("username", null)

        setContent {
            App_Data_MujerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") {
                        StartScreen(onNavigateToLogin = {
                            val currentSharedPrefs = getSharedPreferences("app_prefs", MODE_PRIVATE)
                            val name = currentSharedPrefs.getString("username", null)
                            val science = currentSharedPrefs.getString("science", null)
                            if (!name.isNullOrBlank() && !science.isNullOrBlank()) {
                                navController.navigate("home/$name") {
                                    popUpTo("start") { inclusive = false }
                                }
                            } else {
                                navController.navigate("login")
                            }
                        })
                    }
                    composable("login") {
                        LoginScreen(
                            onBack = { navController.popBackStack() },
                            onLoginSuccess = { username ->
                                navController.navigate("home/$username") {
                                    popUpTo("start") { inclusive = true }
                                }
                            }
                        )
                    }
                    composable(
                        route = "home/{username}",
                        arguments = listOf(navArgument("username") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val username = backStackEntry.arguments?.getString("username") ?: savedUsername ?: "Fiorella"
                        HomeScreen(
                            username = username,
                            onCategoryClick = { categoryName ->
                                // TODO: Handle category click
                            },
                            onAboutClick = {
                                navController.navigate("info")
                            }
                        )
                    }
                    composable("info") {
                        InfoDataMujerScreen(onBack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
