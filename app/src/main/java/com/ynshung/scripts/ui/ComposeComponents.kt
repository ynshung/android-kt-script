package com.ynshung.scripts.ui

import androidx.compose.runtime.Composable
import com.ynshung.scripts.compose.components.ImageComp
import com.ynshung.scripts.compose.components.RowInfo
import com.ynshung.scripts.compose.components.RowMultipleInfo

@Composable
fun ComposeComponents() {
    ImageComp(fileName = "invalid_file.jpg", size = 64)

    DividerPadding()

    RowInfo(
        map = mapOf(
            "Name" to "John Smith",
            "Gender" to "Male",
            "Nationality" to "Malaysia"
        ),
        keyWeight = 0.4f
    )

    DividerPadding()

    RowMultipleInfo(
        map = mapOf(
            "Name" to "John Smith",
            "Gender" to "Male"
        )
    )
}

