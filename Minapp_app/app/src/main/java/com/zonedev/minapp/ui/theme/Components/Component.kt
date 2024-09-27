package com.zonedev.minapp.ui.theme.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTextField(value: String, label: String, onValueChange: (String) -> Unit, isEnabled: Boolean = true) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        enabled = isEnabled,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            disabledIndicatorColor = Color.Transparent,
            disabledLabelColor = Color.Gray
        )
    )
}

@Composable
fun Navbar(Titule:String) {
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
            contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Burger),
            tint = colorResource(R.color.background),
            modifier = Modifier.size(30.dp)
        )
        Text(
            text = Titule,
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(end = 140.dp, top = 5.dp)
        )
        Row {
            Icon(
                painter = painterResource(id = R.drawable.notificacion),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Notificacion),
                tint = colorResource(R.color.background),
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Icon(
                painter = painterResource(id = R.drawable.power_off),
                contentDescription = stringResource(R.string.Descripcion_Navbar_Icon_Power),
                modifier = Modifier.size(40.dp),
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
        colors = ButtonDefaults.buttonColors(Color(0xFF0056D2)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 18.sp)
    }
}
