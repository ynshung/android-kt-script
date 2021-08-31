package com.ynshung.scripts.compose.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Multiple rows of text that contains bolded key and value, uses SingleRowInfo
@Composable
fun RowInfo(map: Map<String, String>, keyWeight: Float = 0.25f) {
    map.onEachIndexed { index, entry ->
        SingleRowInfo(key = entry.key, value = entry.value, keyWeight = keyWeight)
        if (index < map.size - 1) {
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun RowInfoPreview() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        RowInfo(
            map = mapOf(
                "Name" to "John Smith",
                "Gender" to "Male",
                "Nationality" to "Malaysia"
            ),
            keyWeight = 0.3f
        )

    }
}
