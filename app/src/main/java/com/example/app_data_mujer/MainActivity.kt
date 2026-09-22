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
        setContent {
            App_Data_MujerTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "start") {
                    composable("start") {
                        StartScreen(onNavigateToLogin = {
                            navController.navigate("login")
                        })
                    }
                    composable("login") {
                        LoginScreen(
                            onBack = { navController.popBackStack() },
                            onLoginSuccess = { username ->
                                navController.navigate("home/$username") {
                                    popUpTo("start") { inclusive = false }
                                }
                            }
                        )
                    }
                    composable(
                        route = "home/{username}",
                        arguments = listOf(navArgument("username") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val username = backStackEntry.arguments?.getString("username") ?: "Fiorella"
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
