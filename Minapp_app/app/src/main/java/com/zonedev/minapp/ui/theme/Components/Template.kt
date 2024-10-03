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
        CameraCaptureExample(vals)
        //Camara de Identificacion
        CameraCaptureExample()
        //Componentes
        Components_Template()
    }else{
        //Camara de Elementos
        CameraCaptureExample(vals)
        //Componentes
        Components_Template()
    }
}

@Composable
fun Template_Text(IsScreenElement: Boolean=false,Label_Id:String= stringResource(R.string.Value_Default_Label_Id)){
    //variables de los textfield
    var Id by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    if (IsScreenElement){
        CameraCaptureExample(stringResource(R.string.Value_Label_Element))
    }
    CustomTextField(
        value = Id,
        label = Label_Id,
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

    Components_Template()
}
@Composable
fun Components_Template(content: @Composable (() -> Unit)?=null){

    CheckHold()
    FieldsThemes()
    //Button Submit
    ButtonApp(stringResource(R.string.button_submit), { print("Hola") })
    //Line diviser
    Separetor()
}