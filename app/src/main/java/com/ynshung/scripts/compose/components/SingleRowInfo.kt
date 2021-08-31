package com.ynshung.scripts.compose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// A row that contains bolded key and value, used in RowInfo
@Composable
fun SingleRowInfo(key: String, value: String, keyWeight: Float = 0.25f) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = key,
            modifier = Modifier.weight(keyWeight - 0.05f),
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(0.1f))
        Text(
            text = value,
            modifier = Modifier.weight(0.95f - keyWeight)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SingleRowInfoPreview() {
    Column(
        modifier = Modifier.padding(24.dp)
    ) {
        SingleRowInfo(key = "Name", value = "John Smith")
    }
}
