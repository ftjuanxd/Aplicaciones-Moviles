package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.background
import com.zonedev.minapp.ui.theme.bodyFontFamily
import com.zonedev.minapp.ui.theme.primary


// Login Screen
@Composable
fun LoginApp(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BlobUi()
        Spacer(modifier = Modifier.height((-20).dp)) // Reduce la altura entre componentes
        CustomLoginScreen(navController)
    }
}

@Composable
fun BlobUi() {
    val blob = painterResource(R.drawable.blob)
    Box(modifier = Modifier.wrapContentHeight()) {
        Image(
            painter = blob,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopEnd,
            modifier = Modifier.absoluteOffset(x = (-40).dp, y = (-190).dp)
        )
        Text(
            text = stringResource(R.string.blob_ui_text),
            fontWeight = FontWeight.Bold,
            color = Color.White,
            fontSize = 40.sp,
            fontFamily = bodyFontFamily,
            textAlign = TextAlign.Start,
            modifier = Modifier.absoluteOffset(x = 20.dp, y = 80.dp)
        )
    }
}

@Composable
fun CustomLoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // Se crea el NavController para manejar la navegación

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = email,
            label = stringResource(R.string.Label_name_input_user),
            onValueChange = { email = it },
            isEnabled = true,
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            R.drawable.user_icon,
            primary
        )

        CustomTextField(
            value = password,
            label = stringResource(R.string.Label_name_Input_password),
            onValueChange = { password = it },
            isEnabled = true,
            KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done,
            ),
            R.drawable.lock_icon,
            primary
        )

        // Usamos ButtonApp en lugar de Button
        ButtonApp(stringResource(R.string.name_button_login),{navController.navigate("profile_screen")},)
        // Llamada al NavHost que maneja la navegación entre pantallas
    }
}