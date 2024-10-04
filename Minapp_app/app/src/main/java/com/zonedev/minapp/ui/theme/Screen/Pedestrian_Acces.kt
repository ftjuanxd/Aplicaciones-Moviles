package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.BaseScreen
import com.zonedev.minapp.ui.theme.Components.SegmentedButton
import com.zonedev.minapp.ui.theme.Components.Template_Scan
import com.zonedev.minapp.ui.theme.Components.Template_Text

@Composable
fun Acces() {
    BaseScreen(
        stringResource(R.string.Name_Interfaz_Pedestrian_Access),
        R.drawable.notificacion,
        R.drawable.logo_home,
        content = {
            SegmentedButton(
                {
                    Template_Scan()
                },
                {
                    Template_Text()
                }
            )
        },
        15.sp,40.dp,80.dp
    )
}