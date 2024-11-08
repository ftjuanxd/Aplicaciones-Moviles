package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.zonedev.minapp.R
import com.zonedev.minapp.ui.theme.Components.SegmentedButton
import com.zonedev.minapp.ui.theme.Components.Template_Scan
import com.zonedev.minapp.ui.theme.Components.Template_Text

@Composable
fun Element(guardiaId: String) {
    SegmentedButton(
        {
            Template_Scan(true, stringResource(R.string.Value_Label_Element),guardiaId)
        },
        {
            Template_Text(true, guardiaId = guardiaId)
        }
    )
}