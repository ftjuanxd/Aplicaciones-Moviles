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
fun Element() {
    BaseScreen(
        stringResource(R.string.Name_Interfaz_Element),
        R.drawable.notificacion,
        R.drawable.logo_home,
        content = {
            SegmentedButton(
                {
                    Template_Scan(true, stringResource(R.string.Value_Label_Element))
                },
                {
                    Template_Text(true)
                }
            )
        },
        25.sp,40.dp,130.dp
    )
}