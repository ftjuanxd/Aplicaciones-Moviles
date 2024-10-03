package com.zonedev.minapp.ui.theme.Components

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.background
import com.zonedev.minapp.ui.theme.color_component
import com.zonedev.minapp.ui.theme.primary


@Composable
fun BaseScreen(
    title: String,
    notificationIcon: Int,
    logoIcon: Int,
    content: @Composable () -> Unit, // Puedes cambiar el color de fondo según sea necesario
    fontSizeTitule: TextUnit,
    SizeIcon: Dp,
    endPadding: Dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(background),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Navbar(title, notificationIcon, logoIcon, fontSizeTitule, SizeIcon, endPadding)
        Spacer(modifier = Modifier.height(50.dp))
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            content()//Aqui se muestra el contenido de cada pantalla
        }
    }
}

@Composable
fun Separetor() {
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
    isEnabled: Boolean = true,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
    @DrawableRes trailingIcon: Int? = null,
    iconTint: Color? = null,
    pdHeight: Dp? = null,
    onClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier,
    bitmap: Bitmap? = null // Nuevo parámetro para la imagen capturada
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        enabled = isEnabled,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(2.dp, primary, RoundedCornerShape(12.dp))
            .let { if (pdHeight != null) it.height(pdHeight) else it }
            .clickable {
                // Solo se ejecuta si onClick no es null
                onClick?.invoke()
            },
        keyboardOptions = keyboardOptions,
        trailingIcon = {
            if (bitmap != null) {
                // Mostrar la imagen capturada dentro del TextField
                Image(
                    bitmap = bitmap.asImageBitmap(),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
            } else if (trailingIcon != null) {
                // Si no hay imagen, mostrar el ícono habitual
                Icon(
                    painter = painterResource(id = trailingIcon),
                    contentDescription = null,
                    tint = iconTint ?: Color.Black
                )
            }
        },
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            disabledLabelColor = Color.Transparent,
            containerColor = background,
            disabledTextColor = MaterialTheme.colorScheme.onSurface // Color predeterminado para texto deshabilitado
        )
    )
}


@Composable
fun Navbar(Titule:String, @DrawableRes Activenotificacion: Int, @DrawableRes home_power: Int, fontSizeTitule: TextUnit, SizeIcon: Dp, endPadding: Dp) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(primary)
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.logo_menu_burger),
            contentDescription = Titule,
            tint = colorResource(R.color.background),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = Titule,
            color = Color.White,
            fontSize = fontSizeTitule,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(end = endPadding, top = 5.dp)//menu end=180.dp
        )
        Row{
            Icon(
                painter = painterResource(id = Activenotificacion),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Notificacion),
                tint = colorResource(R.color.background),
                modifier = Modifier.size(SizeIcon)
            )
            //Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id =home_power),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Power),
                modifier = Modifier.size(SizeIcon),
                tint = colorResource(R.color.background)
            )
        }
    }
}

@Composable
fun ButtonApp(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(primary),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}

@Composable
fun UploadFileScreen() {
    // Estado para almacenar la URI del archivo seleccionado
    var fileUri by remember { mutableStateOf<Uri?>(null) }

    // Registro del lanzador de actividad para seleccionar archivos
    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument(),
        onResult = { uri: Uri? ->
            fileUri = uri // Se actualiza el estado con la URI seleccionada
        }
    )
    // Columna principal para organizar los elementos
    Column {
        // OutlinedTextField simula el área de carga de archivos
        CustomTextField(
            value = fileUri?.path ?: stringResource(R.string.Label_Upload_Files), // Muestra la ruta del archivo seleccionado o vacío
            onValueChange = {},
            label = stringResource(R.string.Label_Upload_Files),
            isEnabled = false,
            pdHeight = 140.dp,
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    // Al hacer clic en el OutlinedTextField se lanza el selector de archivos
                    filePickerLauncher.launch(arrayOf("image/*"))
                }
        )

        // Mostrar la ruta del archivo seleccionado si existe
        fileUri?.let {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Archivo seleccionado: ${it.path}")
        }
    }
}

@Composable
fun SegmentedButton(ScanComponent: @Composable () -> Unit, TextComponent: @Composable () -> Unit) {
    // Estado que almacena qué botón está seleccionado (0 para Scan Id, 1 para Write)
    var selectedButton by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier
            .border(5.dp, color_component, RoundedCornerShape(16.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { selectedButton = 0 }, // Acción de seleccionar Scan Id
            shape = RoundedCornerShape(topStart = 8.dp, bottomStart = 8.dp),
            colors = if (selectedButton == 0) {
                // Si el botón está seleccionado, cambia el color
                ButtonDefaults.buttonColors(containerColor = color_component, contentColor = background)
            } else {
                // Si no está seleccionado, usa estos colores
                ButtonDefaults.buttonColors(containerColor = background, contentColor = color_component)
            },
            modifier = Modifier
                .weight(2f)//
        ) {
            Text(
                text = stringResource(R.string.Value_Default_Label_Camera),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Button(
            onClick = { selectedButton = 1 }, // Acción de seleccionar Write
            shape = RoundedCornerShape(topEnd = 8.dp, bottomEnd = 8.dp),
            colors = if (selectedButton == 1) {
                ButtonDefaults.buttonColors(containerColor = color_component, contentColor = background)
            } else {
                ButtonDefaults.buttonColors(containerColor = background, contentColor = color_component)
            },
            modifier = Modifier
                .weight(2f)
        ) {
            Text(
                text = stringResource(R.string.Value_Segmented_Button),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)
        }
    }
    // Aquí se muestra el contenido según el botón seleccionado
    Spacer(modifier = Modifier.height(16.dp)) // Espacio entre los botones y el contenido
    when (selectedButton) {
        0 -> ScanComponent() // Mostrar contenido de Scan Id
        1 -> TextComponent()   // Mostrar contenido de Write
    }
}

@Composable
fun CheckHold() {
    // Estado del Checkbox
    var isChecked by remember { mutableStateOf(false) }

    // Contenedor con el Checkbox y un Text para mostrar el estado
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(end=220.dp)
    ) {
        Box(
            modifier = Modifier
                .size(23.dp)  // Tamaño del checkbox
                .border(2.dp, primary, RoundedCornerShape(4.dp))  // Borde personalizado
                .padding(4.dp)  // Espacio entre el borde y el checkbox
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }, // Actualiza el estado cuando se hace clic
                colors = CheckboxDefaults.colors(
                    checkedColor = primary,        // Color cuando está marcado
                    uncheckedColor = background,      // Color cuando está desmarcado
                    checkmarkColor = background,      // Color del check
                )
            )
        }
        Spacer(modifier = Modifier.width(8.dp)) // Espacio entre el Checkbox y el texto
        Text(
            text = stringResource(R.string.Name_CheckHolder),
            fontSize = 15.sp
        )
    }
}

@Composable
fun FieldsThemes() {
    var destiny by remember { mutableStateOf("") }
    var auto by remember { mutableStateOf("") }
    var descrip by remember { mutableStateOf("") }

    CustomTextField(
        value = destiny,
        label = "Destiny",
        onValueChange = { destiny = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    //TextField Authorization
    CustomTextField(
        value = auto,
        label = "Authorization",
        onValueChange = { auto = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Next,
        )
    )
    //TextField Description
    CustomTextField(
        value = descrip,
        label = "Description",
        onValueChange = { descrip = it },
        isEnabled = true,
        KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done,
        ),
        pdHeight = 80.dp
    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CameraCaptureExample(vals:String = stringResource(R.string.Value_Default_Label_Camera)) {
    val context = LocalContext.current
    var capturedBitmap by remember { mutableStateOf<Bitmap?>(null) }

    // Intent para capturar imagen
    val takePictureLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { bitmap ->
        if (bitmap != null) {
            capturedBitmap = bitmap
        }
    }
    // Custom TextField que muestra la imagen capturada
    CustomTextField(
        value = vals,
        onValueChange = {},
        isEnabled = false,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        label = "Upload File",
        pdHeight = 120.dp,
        onClick = {
            // Llamar el intent de captura de foto
            takePictureLauncher.launch(null)
        },
        bitmap = capturedBitmap // Pasar la imagen capturada al TextField
    )
}