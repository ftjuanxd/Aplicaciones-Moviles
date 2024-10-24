package com.zonedev.minapp.ui.theme.Components


import android.text.Layout
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import com.zonedev.minapp.ui.theme.primary

@Composable
fun Template_Scan(IsScreenElement: Boolean=false,vals:String = stringResource(R.string.Value_Default_Label_Camera)){

    if (IsScreenElement){
        //Camara de elementos
        CameraCapture(vals)
        //Camara de Identificacion
        CameraCapture()
        //Componentes
        Components_Template()
    }else{
        //Camara de Elementos
        CameraCapture(vals)
        //Componentes
        Components_Template()
    }
}

@Composable
fun Template_Text(IsScreenElement: Boolean = false, Label_Id: String = stringResource(R.string.Value_Default_Label_Id)) {
    // Variables de los textfields
    var Id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    if (IsScreenElement) {
        CameraCapture(stringResource(R.string.Value_Label_Element))
    }
    CustomTextField(
        value = Id,
        label = Label_Id,
        onValueChange = { Id = it },
        isEnabled = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    // TextField Authorization
    CustomTextField(
        value = name,
        label = "Name",
        onValueChange = { name = it },
        isEnabled = true,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    Components_Template()
}

@Composable
fun Components_Template() {

    // Controla si se muestra el modal
    var showDialog by remember { mutableStateOf(false) }

    CheckHold()
    FieldsThemes()

    // Botón Submit que abre el modal
    ButtonApp(stringResource(R.string.button_submit)) { showDialog = true }
    // Mostrar el modal si showModal es true

    // Componente Modal
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text(
                    text = stringResource(R.string.Name_Modal_Report),
                    color = primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            },

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

    // Línea divisora
    Separetor()
}