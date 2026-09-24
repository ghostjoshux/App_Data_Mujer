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
                                navController.navigate("category/$categoryName")
                            },
                            onAboutClick = {
                                navController.navigate("info")
                            },
                            onScientistClick = { scientistName ->
                                when (scientistName) {
                                    "Sophie Germain" -> navController.navigate("scientist/sophie_germain")
                                    "Sofía Kovalevskaya" -> navController.navigate("scientist/sofia_kovalevskaya")
                                    "Emmy Noether" -> navController.navigate("scientist/emmy_noether")
                                    "Maryam Mirzakhani" -> navController.navigate("scientist/maryam_mirzakhani")
                                    "Sun-Yung Alice Chang" -> navController.navigate("scientist/sun_yung")
                                    "Lise Meitner" -> navController.navigate("scientist/lise_meitner")
                                    "Mary Tsingou" -> navController.navigate("scientist/mary_tsingou")
                                    "Donna Strickland" -> navController.navigate("scientist/donna_strickland")
                                    "Helen Czerski" -> navController.navigate("scientist/helen_czerski")
                                    "Stephanie Kwolek" -> navController.navigate("scientist/stephanie_kwolek")
                                    "Marie-Anne Pierrette Paulze-Lavoisier" -> navController.navigate("scientist/marie_anne")
                                    "Irène Joliot-Curie" -> navController.navigate("scientist/irene_joliot")
                                    "Marie Curie" -> navController.navigate("scientist/marie_curie")
                                    "Rosalind Franklin" -> navController.navigate("scientist/rosalind_franklin")
                                }
                            }
                        )
                    }
                    composable(
                        route = "category/{categoryName}",
                        arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
                    ) { backStackEntry ->
                        val categoryName = backStackEntry.arguments?.getString("categoryName") ?: "Matemáticas"
                        CategoryDetailScreen(
                            categoryName = categoryName,
                            onBack = { navController.popBackStack() },
                            onScientistClick = { scientistName ->
                                if (scientistName.equals("Sophie Germain", ignoreCase = true)) {
                                    navController.navigate("scientist/sophie_germain")
                                } else if (scientistName.equals("Sofía Kovalevskaya", ignoreCase = true)) {
                                    navController.navigate("scientist/sofia_kovalevskaya")
                                } else if (scientistName.equals("Emmy Noether", ignoreCase = true)) {
                                    navController.navigate("scientist/emmy_noether")
                                } else if (scientistName.equals("Maryam Mirzakhani", ignoreCase = true)) {
                                    navController.navigate("scientist/maryam_mirzakhani")
                                } else if (scientistName.equals("Sun-Yung Alice Chang", ignoreCase = true)) {
                                    navController.navigate("scientist/sun_yung")
                                } else if (scientistName.equals("Lise Meitner", ignoreCase = true)) {
                                    navController.navigate("scientist/lise_meitner")
                                } else if (scientistName.equals("Mary Tsingou", ignoreCase = true)) {
                                    navController.navigate("scientist/mary_tsingou")
                                } else if (scientistName.equals("Donna Strickland", ignoreCase = true)) {
                                    navController.navigate("scientist/donna_strickland")
                                } else if (scientistName.equals("Helen Czerski", ignoreCase = true)) {
                                    navController.navigate("scientist/helen_czerski")
                                } else if (scientistName.equals("Stephanie Kwolek", ignoreCase = true)) {
                                    navController.navigate("scientist/stephanie_kwolek")
                                } else if (scientistName.contains("Marie-Anne", ignoreCase = true) || scientistName.contains("Lavoisier", ignoreCase = true)) {
                                    navController.navigate("scientist/marie_anne")
                                } else if (scientistName.contains("Irène", ignoreCase = true) || scientistName.contains("Irene", ignoreCase = true) || scientistName.contains("Joliot", ignoreCase = true)) {
                                    navController.navigate("scientist/irene_joliot")
                                } else if (scientistName.equals("Marie Curie", ignoreCase = true)) {
                                    navController.navigate("scientist/marie_curie")
                                } else if (scientistName.contains("Rosalind", ignoreCase = true) || scientistName.contains("Franklin", ignoreCase = true)) {
                                    navController.navigate("scientist/rosalind_franklin")
                                }
                            },
                            onAboutClick = {
                                navController.navigate("info")
                            }
                        )
                    }
                    composable("scientist/sophie_germain") {
                        SophieGermainDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/sofia_kovalevskaya") {
                        SofiaKovalevskayaDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/emmy_noether") {
                        EmmyNoetherDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/maryam_mirzakhani") {
                        MaryamMirzakhaniDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/sun_yung") {
                        SunYungAliceChangDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/lise_meitner") {
                        LiseMeitnerDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/mary_tsingou") {
                        MaryTsingouDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/donna_strickland") {
                        DonnaStricklandDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/helen_czerski") {
                        HelenCzerskiDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/stephanie_kwolek") {
                        StephanieKwolekDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/marie_anne") {
                        MarieAnnePaulzeLavoisierDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/irene_joliot") {
                        IreneJoliotCurieDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/marie_curie") {
                        MarieCurieDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
                        )
                    }
                    composable("scientist/rosalind_franklin") {
                        RosalindFranklinDetailScreen(
                            onBack = { navController.popBackStack() },
                            onFollowExploring = { navController.popBackStack() }
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
