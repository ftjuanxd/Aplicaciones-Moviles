package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.runtime.Composable
import com.zonedev.minapp.ui.theme.Components.SegmentedButton
import com.zonedev.minapp.ui.theme.Components.Template_Scan
import com.zonedev.minapp.ui.theme.Components.Template_Text

@Composable
fun Personal(guardiaId: String) {
    SegmentedButton(
        {
            Template_Scan()
        },
        {
            Template_Text()
        }
    )
}