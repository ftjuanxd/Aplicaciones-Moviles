package com.zonedev.minapp.ui.theme.Screen

import androidx.compose.runtime.Composable
import com.zonedev.minapp.ui.theme.Components.Template_Text

@Composable
fun Element(guardiaId: String) {

    Template_Text(true, guardiaId = guardiaId)

    /**SegmentedButton(
        {
            Template_Scan(true, stringResource(R.string.Value_Label_Element),guardiaId)
        },
        {

        }
    )**/
}