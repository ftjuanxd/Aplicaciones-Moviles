package com.zonedev.minapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.MinappTheme
import com.zonedev.minapp.ui.theme.Screen.LoginApp
import com.zonedev.minapp.ui.theme.Screen.MainScreen
import com.zonedev.minapp.ui.theme.ViewModel.GuardiaViewModel

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var guardiaViewModel: GuardiaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        guardiaViewModel = GuardiaViewModel() // Instancia del ViewModel

        enableEdgeToEdge()
        setContent {
            MinappTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "main") {
                    composable("main"){
                        MainScreen(navController)
                    }
                    composable("login") {
                        LoginApp(navController, auth) { userId ->
                            // Cargar los datos del usuario específico después de un login exitoso
                            guardiaViewModel.getGuardiaById(userId)
                            navController.navigate("profile")
                        }
                    }
                    composable("profile") {
                        BaseScreen(navController=navController, guardiaViewModel = guardiaViewModel)  // Pasar el ViewModel al ProfileScreen
                    }
                }
            }
        }
    }
}
