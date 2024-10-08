package com.zonedev.minapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.MinappTheme
import com.zonedev.minapp.ui.theme.Screen.Personal
import com.zonedev.minapp.ui.theme.Screen.Components_Profile_Screen
import com.zonedev.minapp.ui.theme.Screen.Element
import com.zonedev.minapp.ui.theme.Screen.LoginApp
import com.zonedev.minapp.ui.theme.Screen.MainScreen
import com.zonedev.minapp.ui.theme.Screen.ScreenReport
import com.zonedev.minapp.ui.theme.Screen.Observations
import com.zonedev.minapp.ui.theme.Screen.ProfileScreen
import com.zonedev.minapp.ui.theme.Screen.Vehicular
import com.zonedev.minapp.ui.theme.background
import com.zonedev.minapp.ui.theme.bodyFontFamily
import com.zonedev.minapp.ui.theme.primary
import com.zonedev.minapp.ui.theme.text
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MinappTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = "main") {
                    composable("main") { MainScreen(navController) }
                    composable("login") { LoginApp(navController) }
                    composable("profile") { BaseScreen("home",navController) }
                }
            }
        }
    }
}

