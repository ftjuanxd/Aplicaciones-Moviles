package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.ui.theme.Components.Separetor
import com.zonedev.minapp.ui.theme.Components.UploadFileScreen

@Composable
fun Theme_Observations(){
    BaseScreen(stringResource(R.string.Name_Interfaz_Observations),R.drawable.notificacion,R.drawable.logo_home,
        { Components_Observations() },20.sp,40.dp,100.dp)
}
@Composable
fun Components_Observations(){
    var subject by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }
    //TextField Subject
    CustomTextField(
        value = subject,
        label = stringResource(R.string.label_subject),
        onValueChange = { subject = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    CustomTextField(
        value = observations,
        label = stringResource(R.string.label_observations),
        onValueChange = { observations = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        pdHeight = 140.dp
    )
    UploadFileScreen()
    Separetor()
    // Usamos ButtonApp aquí también
    ButtonApp(text = stringResource(R.string.button_submit),{/*TODO*/})
}