package com.ynshung.scripts.compose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// A row that contains multiple bolded keys and values
@Composable
fun RowMultipleInfo(map: Map<String, String>) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        for ((t, u) in map) {
            Row {
                Text(
                    text = "$t: ",
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = u
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RowMultipleInfoPreview() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        RowMultipleInfo(
            map = mapOf(
                "Name" to "John Smith",
                "Gender" to "Male"
            )
        )
    }
}

