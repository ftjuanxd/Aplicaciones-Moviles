package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.ui.theme.Components.Navbar
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.background
import kotlinx.coroutines.launch

@Preview
@Composable
fun ProfileScreen() {
    Components_Profile_Screen()
}

@Composable
fun Components_Profile_Screen(){
    Image(
        painter = painterResource(id = R.drawable.logo_user_sample),
        contentDescription = stringResource(R.string.Descripcion_profileScreen_Image),
        modifier = Modifier
            .size(160.dp)
            .padding(bottom = 24.dp)
    )

    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(vertical = 8.dp))

    CustomTextField(
        value = "Carlos Cesar Santa Maria",
        label = "Name",
        onValueChange = {},
        isEnabled = false,
    )
    CustomTextField(
        value = "31234567890",
        label = "Phone",
        onValueChange = {},
        isEnabled = false,
    )
    CustomTextField(
        value = "1234567890",
        label = "N° Id",
        onValueChange = {},
        isEnabled = false,

        )
    CustomTextField(
        value = "Male",
        label = "Genre",
        onValueChange = {},
        isEnabled = false,
    )
    CustomTextField(
        value = "O+", label = "Rh", onValueChange = {}, isEnabled = false
    )
    CustomTextField(
        value = "213456789",
        label = "Code used",
        onValueChange = {},
        isEnabled = false,
    )

    // Usamos ButtonApp aquí también
    ButtonApp(text = stringResource(R.string.Text_profileScreen_Button),{/*TODO*/})
}