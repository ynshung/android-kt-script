package com.ynshung.scripts.compose.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog


// Compose loading dialog

@Composable
fun LoadingDialog(
    text: String = "Loading…",
    dismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = { dismiss() }
    ) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 18.dp)
            ) {
                CircularProgressIndicator()
                Spacer(modifier = Modifier.width(24.dp))
                Text(text = text, maxLines = 2, overflow = TextOverflow.Ellipsis)
            }
        }
    }
}
