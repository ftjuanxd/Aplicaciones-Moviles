package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.ButtonApp
import com.zonedev.minapp.ui.theme.Components.Components_Template
import com.zonedev.minapp.ui.theme.Components.CustomTextField
import com.zonedev.minapp.ui.theme.Components.Separetor
import com.zonedev.minapp.ui.theme.Components.UploadFileScreen
import com.zonedev.minapp.ui.theme.primary

@Composable
fun Observations(){
    Components_Observations()
}
@Composable
fun Components_Observations(){
    var subject by remember { mutableStateOf("") }
    var observations by remember { mutableStateOf("") }

    var showDialog by remember { mutableStateOf(false) }


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
    ButtonApp(stringResource(R.string.button_submit)) { showDialog = true }

    // Mostrar el modal si showModal es true

    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = { Text(
                text = stringResource(R.string.Name_Modal_Report),
                color = primary,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            ) },
            text = { Text(
                text = stringResource(R.string.Content_Modal_Report),
                color = Color.Gray,
                modifier = Modifier
                    .padding(bottom = 6.dp)
            ) },
            confirmButton = {
                // Usa el botón personalizado dentro del modal
                ButtonApp(
                    text = stringResource(R.string.Value_Button_Report),
                    onClick = {
                        showDialog = false // Cierra el modal cuando se hace clic en "Aceptar"
                    },
                    //modifier = Modifier.fillMaxWidth()
                )
            }
        )
    }

}