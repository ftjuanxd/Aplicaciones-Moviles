package com.zonedev.minapp.ui.theme.Components

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Screen.Acces
import com.zonedev.minapp.ui.theme.Screen.Element
import com.zonedev.minapp.ui.theme.Screen.LoginApp
import com.zonedev.minapp.ui.theme.Screen.MainScreen
import com.zonedev.minapp.ui.theme.Screen.Observations
import com.zonedev.minapp.ui.theme.Screen.ProfileScreen
import com.zonedev.minapp.ui.theme.Screen.ScreenReport
import com.zonedev.minapp.ui.theme.Screen.Observations
import com.zonedev.minapp.ui.theme.Screen.Vehicular
import com.zonedev.minapp.ui.theme.background
import com.zonedev.minapp.ui.theme.color_component
import com.zonedev.minapp.ui.theme.primary
import com.zonedev.minapp.ui.theme.text
import java.time.format.TextStyle

@Composable
fun BaseScreen(
    title: String,
    notificationIcon: Int,
    logoIcon: Int,
    content: @Composable () -> Unit,
    fontSizeTitule: TextUnit,
    SizeIcon: Dp,
    endPadding: Dp
) {
    var isSidebarVisible by remember { mutableStateOf(false) } // Controlar la visibilidad del sidebar

    val navController = rememberNavController() // NavController para la navegación

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(background),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Pasamos el evento de clic del menú desde el Navbar
            Navbar(title, notificationIcon, logoIcon, fontSizeTitule, SizeIcon, endPadding, onMenuClick = {isSidebarVisible =!isSidebarVisible
            })

            Spacer(modifier = Modifier.height(50.dp))

            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
              content()
            }
        }

        // Fondo semi-transparente que resalta el sidebar
        if (isSidebarVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top=56.dp)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { isSidebarVisible = false } // Al hacer clic en el fondo, se cierra el sidebar
            )
        }

        // Sidebar con animación
        SideBar(
            isVisible = isSidebarVisible,

        )

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
fun Navbar(
    Titule: String,
    @DrawableRes Activenotificacion: Int,
    @DrawableRes home_power: Int,
    fontSizeTitule: TextUnit,
    SizeIcon: Dp,
    endPadding: Dp,
    onMenuClick: () -> Unit, // Agregar una función para manejar el clic en el ícono de menú
) {
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
            modifier = Modifier
                .size(30.dp)
                .clickable{onMenuClick()}
        )
        Text(
            text = Titule,
            color = Color.White,
            fontSize = fontSizeTitule,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(end = endPadding, top = 5.dp)
        )
        Row {
            Icon(
                painter = painterResource(id = Activenotificacion),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Notificacion),
                tint = colorResource(R.color.background),
                modifier = Modifier.size(SizeIcon)
            )
            Icon(
                painter = painterResource(id = home_power),
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
fun CameraCapture(vals:String = stringResource(R.string.Value_Default_Label_Camera)) {
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

//Screen Report
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Pedestrian Access") }
    val options = listOf("Pedestrian Access", "Vehicular", "Element", "Observations")

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { expanded = true },
            colors = ButtonDefaults.buttonColors(containerColor = primary),
            modifier = Modifier
                .wrapContentWidth()
                .align(alignment = Alignment.Center)
                .padding(end = 16.dp, start = 16.dp),
        ) {
            Text(text = selectedOption, color = background)
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown",
                tint = background
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        selectedOption = option
                        expanded = false
                    }
                )
            }
        }
    }
    Separetor()
    Spacer(modifier = Modifier.height(20.dp))

    // Mostrar contenido dependiendo de la opción seleccionada
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        when (selectedOption) {
                "Pedestrian Access" -> PaginationScreen()
                "Vehicular" -> PaginationScreen()
                "Element" -> PaginationScreen()
                "Observations" -> PaginationScreen()
                else -> "Please select an option"
            }
    }
}

@Composable
fun Pagination(
    totalPages: Int,
    currentPage: Int,
    onPageChanged: (Int) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, primary)
            .background(primary)
    ) {
        // Botón de "Previous"
        TextButton(
            onClick = {
                if (currentPage > 1) {
                    onPageChanged(currentPage - 1)
                }
            },
            enabled = currentPage > 1
        ) {
            Text("Previous", color = if (currentPage > 1)  background else color_component)
        }

        //Spacer(modifier = Modifier.width(8.dp))

        // Números de páginas
        for (page in 1..totalPages) {
            TextButton(
                onClick = {
                    onPageChanged(page)
                }
            ) {
                Text(
                    text = page.toString(),
                    color = if (page == currentPage) color_component else background
                )
            }
        }

        //Spacer(modifier = Modifier.width(8.dp))

        // Botón de "Next"
        TextButton(
            onClick = {
                if (currentPage < totalPages) {
                    onPageChanged(currentPage + 1)
                }
            },
            enabled = currentPage < totalPages
        ) {
            Text("Next", color = if (currentPage < totalPages) background else color_component)
        }
    }
}

@Composable
fun ContentForPage(items: List<String>, itemsPerPage: Int, currentPage: Int) {
    val startIndex = (currentPage - 1) * itemsPerPage
    val endIndex = minOf(startIndex + itemsPerPage, items.size)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, color_component, shape = RoundedCornerShape(2.dp))
    ) {
        for (index in startIndex until endIndex) {
            Text(text = items[index], modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun PaginationScreen() {
    var currentPage by remember { mutableStateOf(1) }
    val itemsPerPage = 5 // Número de elementos por página
    val items = List(20) { "Item #${it + 1}" } // Lista de ejemplo con 20 elementos
    val totalPages = (items.size + itemsPerPage - 1) / itemsPerPage // Calcular número de páginas

    Column {

        // Componente de paginación
        Pagination(
            totalPages = totalPages,
            currentPage = currentPage,
            onPageChanged = { newPage ->
                currentPage = newPage
            }
        )
        Spacer(modifier = Modifier.height(12.dp))
        // Mostrar contenido según la página actual
        ContentForPage(items = items, itemsPerPage = itemsPerPage, currentPage = currentPage)

        Spacer(modifier = Modifier.height(16.dp))

    }
}

@Composable
fun SideBar(isVisible: Boolean) {
    val offsetX by animateDpAsState(
        targetValue = if (isVisible) 0.dp else (-178).dp, // Mostrar/ocultar sidebar
        animationSpec = tween(durationMillis = 300) // Animación suave
    )

    Box(
        modifier = Modifier
            .offset(x = offsetX)
            .fillMaxHeight()
            .width(200.dp)
            .padding(top=56.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(primary)
                .padding(top = 5.dp, start = 6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Aquí van los íconos de tu sidebar
            Icon(
                painter = painterResource(R.drawable.logo_observations),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_vehicular),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_personal),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_elements),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_report),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}