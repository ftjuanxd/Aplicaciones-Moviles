package com.zonedev.minapp.ui.theme.Components

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Screen.Chat
import com.zonedev.minapp.ui.theme.Screen.Element
import com.zonedev.minapp.ui.theme.Screen.Observations
import com.zonedev.minapp.ui.theme.Screen.Personal
import com.zonedev.minapp.ui.theme.Screen.ProfileScreen
import com.zonedev.minapp.ui.theme.Screen.ScreenReport
import com.zonedev.minapp.ui.theme.Screen.Vehicular
import com.zonedev.minapp.ui.theme.ViewModel.GuardiaViewModel
import com.zonedev.minapp.ui.theme.background
import com.zonedev.minapp.ui.theme.color_component
import com.zonedev.minapp.ui.theme.primary

@Composable
fun BaseScreen(opc : String = "home", navController: NavController,guardiaViewModel: GuardiaViewModel) {
    var opcClic by remember { mutableStateOf(opc) }
    var isSidebarVisible by remember { mutableStateOf(false) }

    // Variable para marcar si vienes desde "home"
    var isFromHome by remember { mutableStateOf(false) }

    // Variables dinámicas para el contenido del Navbar
    var title by remember { mutableStateOf(R.string.Descripcion_Navbar_Icon_Profile_Screen) }
    var notificationIcon by remember { mutableStateOf(R.drawable.notificacion) }
    var logoIcon by remember { mutableStateOf(R.drawable.power_off) }
    var fontSizeTitule by remember { mutableStateOf(20.sp) }
    var SizeIcon by remember { mutableStateOf(40.dp) }
    var endPadding by remember { mutableStateOf(180.dp) }
    var previousPage by remember { mutableStateOf("home") }

    // Actualizamos los valores de Navbar según la opción seleccionada
    when (opcClic) {
        "obs" -> {
            title = R.string.Name_Interfaz_Observations
            notificationIcon = R.drawable.notificacion
            logoIcon = R.drawable.logo_home
            fontSizeTitule = 20.sp
            SizeIcon = 40.dp
            endPadding = 100.dp
            previousPage = "obs"
        }
        "veh" -> {
            title = R.string.Name_Interfaz_Vehicular
            notificationIcon = R.drawable.notificacion
            logoIcon = R.drawable.logo_home
            fontSizeTitule = 25.sp
            SizeIcon = 40.dp
            endPadding = 130.dp
            previousPage = "veh"
        }
        // Agregamos las otras opciones de la misma forma
        "home" -> {
            title = R.string.Descripcion_Navbar_Icon_Profile_Screen
            notificationIcon = R.drawable.notificacion
            logoIcon = R.drawable.power_off
            fontSizeTitule = 20.sp
            SizeIcon = 40.dp
            endPadding = 180.dp
        }
        "chat" -> {
            title = R.string.Name_Interfaz_Chat
            notificationIcon = R.drawable.notificacion_disable
            logoIcon = R.drawable.logo_home
            fontSizeTitule = 20.sp
            SizeIcon = 40.dp
            endPadding = 200.dp
        }
        "per" -> {
            title = R.string.Name_Interfaz_Pedestrian_Access
            notificationIcon = R.drawable.notificacion
            logoIcon =  R.drawable.logo_home
            fontSizeTitule = 15.sp
            SizeIcon = 40.dp
            endPadding = 80.dp
            previousPage = "per"
        }
        "ele" -> {
            title = R.string.Name_Interfaz_Element
            notificationIcon = R.drawable.notificacion
            logoIcon =  R.drawable.logo_home
            fontSizeTitule = 25.sp
            SizeIcon = 40.dp
            endPadding = 130.dp
            previousPage = "ele"
        }
        "rep" -> {
            title = R.string.Name_Interfaz_Report
            notificationIcon = R.drawable.notificacion
            logoIcon =  R.drawable.logo_home
            fontSizeTitule = 20.sp
            SizeIcon = 40.dp
            endPadding = 200.dp
            previousPage = "rep"
        }
    }
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
            Navbar(
                Titule = title,
                Activenotificacion = notificationIcon,
                home_power = logoIcon,
                fontSizeTitule = fontSizeTitule,
                SizeIcon = SizeIcon,
                endPadding = endPadding,
                onMenuClick = { isSidebarVisible = !isSidebarVisible },
                onItemClick = { clickedOption ->
                    opcClic = clickedOption
                },
                navController,
                previousPage =  previousPage
            )
            Spacer(modifier = Modifier.height(50.dp))
            Column(
                modifier = Modifier.padding(12.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (opcClic) {
                    "home" -> ProfileScreen(guardiaViewModel)
                    "obs" -> Observations()
                    "veh" -> Vehicular()
                    "chat" -> Chat()
                    "per" -> Personal()
                    "ele" -> Element()
                    "rep" -> ScreenReport()
                }
            }
        }
        // Sidebar y su fondo
        if (isSidebarVisible) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 56.dp)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { isSidebarVisible = false }
            )
        }
        if (isSidebarVisible) {
            SideBar(
                isVisible = isSidebarVisible,
                onItemClick = { clickedOption ->
                    opcClic = clickedOption
                    isSidebarVisible = false
                }
            )
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
    bitmap: Bitmap? = null, // Imagen capturada
    isUser: Boolean? = null // Nuevo parámetro opcional
) {
    // Determinamos la alineación según isUser
    val alignmentModifier = when (isUser) {
        true -> Modifier.fillMaxWidth().wrapContentWidth(Alignment.End) // Alineado a la derecha si es del usuario
        false -> Modifier.fillMaxWidth().wrapContentWidth(Alignment.Start) // Alineado a la izquierda si no es del usuario
        else -> Modifier.fillMaxWidth() // Alineado por defecto si no se pasa ningún valor
    }
    // Aplicamos el modifier junto con el nuevo alignmentModifier
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label,color= color_component) },
        enabled = isEnabled,
        modifier = alignmentModifier
            //.then(modifier) // Se combina el alignmentModifier con el resto del modifier pasado
            .padding(vertical = 8.dp)
            .border(2.dp, primary, RoundedCornerShape(12.dp))
            .let { if (pdHeight != null) it.height(pdHeight) else it }
            .clickable {
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
                // Mostrar el ícono habitual si no hay imagen
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
            disabledTextColor = MaterialTheme.colorScheme.onSurface
        )
    )
}

@Composable
fun Navbar(
    @StringRes Titule: Int,
    @DrawableRes Activenotificacion: Int,
    @DrawableRes home_power: Int,
    fontSizeTitule: TextUnit,
    SizeIcon: Dp,
    endPadding: Dp,
    onMenuClick: () -> Unit, // Para manejar el clic en el menú
    onItemClick: (String) -> Unit, // Manejar los clics de los ítems
    navController: NavController,
    previousPage : String
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
            contentDescription = stringResource(id = Titule),
            tint = colorResource(R.color.background),
            modifier = Modifier
                .size(30.dp)
                .clickable { onMenuClick() } // Abre/cierra el sidebar
        )
        Text(
            text = stringResource(id=Titule),
            color = background,
            fontSize = fontSizeTitule,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(end = endPadding, top = 5.dp)
        )
        Row {
            Icon(
                painter = painterResource(id = Activenotificacion),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Notificacion),
                tint = colorResource(R.color.background),
                modifier = Modifier
                    .size(SizeIcon)
                    .clickable {
                        if (Activenotificacion == R.drawable.notificacion_disable) {
                            // Vuelve a la pantalla anterior
                            onItemClick(previousPage)
                        } else {
                            onItemClick("chat")
                        }
                    }
            )
            Icon(
                painter = painterResource(id = home_power),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Power),
                modifier = Modifier
                    .size(SizeIcon)
                    .clickable {
                        if (home_power == R.drawable.power_off) {
                            navController.navigate("login")
                        } else {
                            onItemClick("home") // Ir al inicio
                        }
                    },
                tint = colorResource(R.color.background)
            )
        }
    }
}

@Composable
fun ButtonApp(
    text: String,
    onClick: () -> Unit,
    //modifier: Modifier = Modifier solo si el diseno base no ocupa todo el espacio del modal
) {
    Button(
        onClick = onClick,
        modifier = Modifier
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
            .fillMaxWidth()
            .background(background),
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
                .width(380.dp)
                .padding(12.dp)
                .align(alignment = Alignment.Center)
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
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
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
            .border(2.dp, primary, shape = RoundedCornerShape(8.dp))
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

    // Controla si se muestra el modal
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .border(2.dp, color_component, shape = RoundedCornerShape(8.dp))
    ) {
        for (index in startIndex until endIndex) {
            Row(modifier = Modifier.fillMaxWidth().clickable {showDialog = true}){
                Text(text = items[index], modifier = Modifier.padding(8.dp))
            }
        }
    }
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
fun SideBar(
    isVisible: Boolean,
    onItemClick: (String) -> Unit // Manejar los clics
) {
    val offsetX by animateDpAsState(
        targetValue = if (isVisible) 0.dp else (-178).dp, // Mostrar/ocultar sidebar
        animationSpec = tween(durationMillis = 300) // Animación suave
    )

    Box(
        modifier = Modifier
            .offset(x = offsetX)
            .fillMaxHeight()
            .width(200.dp)
            .padding(top = 56.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(primary)
                .padding(top = 5.dp, start = 6.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(R.drawable.logo_observations),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onItemClick("obs") // Clic en "Observations"
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_vehicular),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onItemClick("veh") // Clic en "Vehicular"
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_personal),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onItemClick("per") // Clic en "Personal"
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_elements),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onItemClick("ele") // Clic en "Elementos"
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
            Icon(
                painter = painterResource(R.drawable.logo_report),
                contentDescription = null,
                tint = background,
                modifier = Modifier
                    .size(50.dp)
                    .clickable {
                        onItemClick("rep") // Clic en "Report"
                    }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}
