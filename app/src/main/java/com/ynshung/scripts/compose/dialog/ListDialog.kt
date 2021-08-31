package com.ynshung.scripts.compose.dialog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


// Compose dialog that shows lists of options which user select instantly, and return index of chosen element, -1 if dismissed

@Composable
fun ListDialog(
    title: String,
    list: List<String>,
    clicked: (Int) -> Unit
) {
    Dialog(
        onDismissRequest = { clicked(-1) } // Can be removed to disable dismissing
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(top = 24.dp, bottom = 18.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(
                        horizontal = 24.dp,
                    )
                )

                Spacer(Modifier.height(12.dp))

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    list.forEachIndexed { index, text ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { clicked(index) }
                                .padding(vertical = 12.dp, horizontal = 24.dp),
                        ) {
                            Text(text = text, style = MaterialTheme.typography.body1)
                        }
                    }
                }
            }
        }
    }
}
