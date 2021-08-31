package com.ynshung.scripts.compose.dialog

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog


// Compose dialog that shows lists of options in radio form with confirm button, and return index of chosen element, -1 if dismissed

@Composable
fun RadioDialog(
    title: String,
    list: List<String>,
    initialIndex: Int,
    index: (Int) -> Unit
) {
    var selectedOptions by remember { mutableStateOf(initialIndex) }

    Dialog(
        onDismissRequest = { index(-1) } // Can be removed to disable dismissing
    ) {
        Surface(
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier.padding(top = 22.dp)
            ) {
                Text(
                    text = title,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = startPadding)
                )

                Spacer(Modifier.height(12.dp))

                list.forEachIndexed { index, text ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = (selectedOptions == index),
                                onClick = { selectedOptions = index },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = startPadding, vertical = 12.dp),
                    ) {
                        RadioButton(
                            selected = (selectedOptions == index),
                            onClick = null
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1,
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp, end = 8.dp, bottom = 12.dp),
                    horizontalArrangement = Arrangement.End
                ) {
                    TextButton(
                        onClick = { index(-1) }
                    ) {
                        Text(text = "CANCEL")
                    }
                    TextButton(
                        onClick = { index(selectedOptions) },
                    ) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}

private val startPadding = 24.dp
