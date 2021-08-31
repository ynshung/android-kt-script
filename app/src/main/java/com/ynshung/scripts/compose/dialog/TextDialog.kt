package com.ynshung.scripts.compose.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


// Compose dialog that shows title and any composable content, suitable to show temporary information for users

@Composable
fun TextDialog(
    title: String? = null,
    content: @Composable ColumnScope.() -> Unit,
    dismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = { dismiss() }
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium,
        ) {
            Column(
                modifier = Modifier.padding(top = 22.dp, start = 24.dp)
            ) {
                title?.run {
                    Text(
                        text = this,
                        fontWeight = FontWeight.Medium,
                        fontSize = 20.sp,
                        modifier = Modifier.padding(end = 24.dp)
                    )

                    Spacer(Modifier.height(14.dp))
                }

                Column(modifier = Modifier.padding(end = 24.dp), content = content)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 12.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = { dismiss() },
                    ) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
