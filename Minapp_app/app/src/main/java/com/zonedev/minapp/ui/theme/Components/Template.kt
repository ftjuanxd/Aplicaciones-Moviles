package com.zonedev.minapp.ui.theme.Components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.zonedev.minapp.R

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

    // Controla si se muestra el modal
    var showModal by remember { mutableStateOf(false) }

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

    Components_Template {
        // Lógica para mostrar el modal al hacer clic en el botón
        showModal = true
    }

    // Mostrar el modal si showModal es true
    if (showModal) {
        ReportedModal(
            Titule = R.string.Name_Modal_Report,
            Content = R.string.Content_Modal_Report,
            ButtonText = R.string.Value_Button_Report
        ) {
            // Cierra el modal al presionar el botón de cerrar
            showModal = false
        }
    }
}

@Composable
fun Components_Template(content: @Composable (() -> Unit)? = null) {
    CheckHold()
    FieldsThemes()

    // Botón Submit que abre el modal
    ButtonApp(stringResource(R.string.button_submit)) {
        content?.invoke() // Invoca el contenido que abre el modal
    }

    // Línea divisora
    Separetor()
}