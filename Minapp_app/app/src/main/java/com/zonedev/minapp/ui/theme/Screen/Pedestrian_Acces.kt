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
import com.zonedev.minapp.ui.theme.Components.CheckHold
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.ui.theme.Components.FieldsThemes
import com.zonedev.minapp.ui.theme.Components.SegmentedButton
import com.zonedev.minapp.ui.theme.Components.Separetor

@Composable
fun Acces() {
    BaseScreen(
        "PEDESTRIAN ACCESS",
        R.drawable.notificacion,
        R.drawable.logo_home,
        content = {
            SegmentedButton(
                {
                    Components_Acces_Scan()
                },
                {
                    Components_Acces_Text()
                }
            )
        },
        15.sp,40.dp,80.dp
    )
}

@Composable
fun Components_Acces_Scan(){
    //variables de los textfield
    var destiny by remember { mutableStateOf("") }
    var auto by remember { mutableStateOf("") }
    var descrip by remember { mutableStateOf("") }

    CheckHold()

    FieldsThemes()

    //Button Submit
    ButtonApp(stringResource(R.string.button_submit), { print("Hola") })
    //Line diviser
    Separetor()
}
@Composable
fun Components_Acces_Text(){
    //variables de los textfield
    var Id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    CustomTextField(
        value = Id,
        label = "Id",
        onValueChange = { Id = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    //TextField Authorization
    CustomTextField(
        value = name,
        label = "Name",
        onValueChange = { name = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )

    CheckHold()
    //TextFieldS
    FieldsThemes()
    //Button Submit
    ButtonApp(stringResource(R.string.button_submit), { print("Hola") })
    //Line diviser
    Separetor()
}

