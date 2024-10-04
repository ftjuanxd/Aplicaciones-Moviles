package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.Components.DropdownMenu
import com.zonedev.minapp.ui.theme.Components.Separetor

@Composable
fun ScreenReport(){
    BaseScreen("REPORT", R.drawable.notificacion,R.drawable.logo_home, {DropdownMenu()},20.sp,40.dp,200.dp)
}