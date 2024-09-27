package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.bodyFontFamily


// Login Screen
@Composable
fun LoginApp() {
    BlobUi()
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(100.dp))
        CustomLoginScreen()
    }
}

@Composable
fun BlobUi() {
    val blob = painterResource(R.drawable.blob)
    Box {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomLoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomTextField(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            isEnabled = true
        )

        CustomTextField(
            value = password,
            onValueChange = { password = it },
            label = "Password",
            isEnabled = true
        )

        // Usamos ButtonApp en lugar de Button
        ButtonApp(stringResource(R.string.name_button_login),{/*TODO*/})
    }
}