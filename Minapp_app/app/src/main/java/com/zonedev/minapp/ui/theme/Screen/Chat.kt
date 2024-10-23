package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.ui.theme.primary

@Preview
@Composable
fun Chat(){
    ComponentsChat()
}
@Composable
fun ComponentsChat(){

    data class Item(val value: String, val label: String)

    val values = listOf(
        Item("Con respecto a su problema el supervisor esta en camino",stringResource(R.string.Label_Value_Central)),
        Item("Gracias, estare al tanto", stringResource(R.string.Label_Value_Employ)),
        Item("Me confirma la llegada",stringResource(R.string.Label_Value_Central)),
        Item("Si ya llego estamos solucinando las cosas",stringResource(R.string.Label_Value_Employ)),
        Item("Envie imagenes sobre la solucion al problema",stringResource(R.string.Label_Value_Central))
    )

    var typetext by remember { mutableStateOf("") }


    Column {
        Image(
            painter = painterResource(id = R.drawable.logo_user_sample),
            contentDescription = stringResource(R.string.Descripcion_profileScreen_Image),
            modifier = Modifier
                .size(160.dp)
                .padding(bottom = 24.dp)
                .align(alignment = Alignment.CenterHorizontally)
        )

        values.forEach { item ->
            Row(
                horizontalArrangement = if (item.label != "central") Arrangement.End else Arrangement.Start // Alinea según el remitente
            ) {
                CustomTextField(
                    value = item.value,
                    onValueChange = {},
                    label = item.label,
                    isEnabled = false,
                    isUser = (item.label == "central")
                )
            }
        }
        CustomTextField(
            value = typetext,
            onValueChange = {typetext = it},
            label = "",
            isEnabled = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
            ),
            trailingIcon = R.drawable.logon_send,
            iconTint = primary,
        )

    }
}