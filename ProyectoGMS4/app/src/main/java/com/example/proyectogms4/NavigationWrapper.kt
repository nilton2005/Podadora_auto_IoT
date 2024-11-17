package com.example.proyectogms4

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyectogms4.presentation.home.DashboardScreen
import com.example.proyectogms4.presentation.home.HomeScreen
import com.example.proyectogms4.presentation.home.ManualScreen
import com.example.proyectogms4.presentation.home.NewsScreen
import com.example.proyectogms4.presentation.home.SettingsScreen
import com.example.proyectogms4.presentation.home.TestingScreen
import com.example.proyectogms4.presentation.home.WeatherScreen
import com.example.proyectogms4.presentation.initial.InitialScreen
import com.example.proyectogms4.presentation.login.LoginScreen
import com.example.proyectogms4.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun NavigationWrapper(
    navHostController: NavHostController,
    auth: FirebaseAuth,
    db: FirebaseFirestore
) {
    // Definir el NavHost con rutas para cada pantalla
    NavHost(navController = navHostController, startDestination = "initial") {

        // Pantalla inicial
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("logIn") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }

        // Pantalla de inicio de sesión
        composable("logIn") {
            LoginScreen(
                auth = auth,
                navHostController = navHostController
            )
        }

        // Pantalla de registro
        composable("signUp") {
            SignUpScreen(
                auth = auth,
                navHostController = navHostController
            )
        }

        // Pantalla de inicio
        composable("home") {
            HomeScreen(
                db = db,
                navHostController = navHostController
            )
        }

        // Pantalla del dashboard
        composable("dashboard") {
            DashboardScreen(navHostController = navHostController)
        }

        // Pantalla de configuración
        composable("settings") {
            SettingsScreen(navHostController = navHostController)
        }

        // Pantalla de noticias
        composable("news") {
            NewsScreen(navHostController = navHostController)
        }

        // Pantalla del clima
        composable("weather") {
            WeatherScreen(navHostController = navHostController)
        }

        // Pantalla de pruebas
        composable("testing") {
            TestingScreen(navHostController = navHostController)
        }

        // Pantalla del manual
        composable("manual") {
            ManualScreen(navHostController = navHostController)
        }
    }
}

