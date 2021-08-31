package com.ynshung.scripts.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.ynshung.scripts.compose.dialog.ListDialog
import com.ynshung.scripts.compose.dialog.LoadingDialog
import com.ynshung.scripts.compose.dialog.RadioDialog
import com.ynshung.scripts.compose.dialog.TextDialog
import com.ynshung.scripts.kotlin.ContextLauncher
import com.ynshung.scripts.ui.types.ComposeDialogType

@Composable
fun ComposeDialog() {
    var composeDialogType by remember { mutableStateOf(ComposeDialogType.NONE) }
    val contextLauncher = ContextLauncher(LocalContext.current)

    when (composeDialogType) {
        ComposeDialogType.NONE -> {
        }
        ComposeDialogType.LIST_DIALOG -> {
            ListDialog(
                title = "This is the title",
                list = listOf(
                    "Option 1", "Option 2", "Option 3"
                ),
                clicked = {
                    contextLauncher.showToast("Selected option ${it + 1}")
                    composeDialogType = ComposeDialogType.NONE
                }
            )
        }
        ComposeDialogType.LOADING_DIALOG -> {
            LoadingDialog(text = "Custom loading text") {
                contextLauncher.showToast("Dismissed.")
                composeDialogType = ComposeDialogType.NONE
            }
        }
        ComposeDialogType.RADIO_DIALOG -> {
            RadioDialog(
                title = "This is the title",
                list = listOf(
                    "Option 1", "Option 2", "Option 3"
                ),
                initialIndex = 0,
                index = {
                    contextLauncher.showToast("Selected option ${it + 1}")
                    composeDialogType = ComposeDialogType.NONE
                }
            )
        }
        ComposeDialogType.TEXT_DIALOG -> {
            TextDialog(
                title = "This is the title",
                content = {
                    Text("Here is where you can put any composable content here.")
                    Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce at fringilla purus, eu blandit est.")
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(Icons.Default.Email, contentDescription = null)
                        Spacer(Modifier.width(12.dp))
                        Text("Contact me with email: example@gmail.com")
                    }
                },
                dismiss = {
                    contextLauncher.showToast("Dismissed.")
                    composeDialogType = ComposeDialogType.NONE
                }
            )
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            composeDialogType = ComposeDialogType.LIST_DIALOG
        }) {
            Text("List Dialog")
        }

        Button(onClick = {
            composeDialogType = ComposeDialogType.LOADING_DIALOG
        }) {
            Text("Loading Dialog")
        }
    }
    Spacer(Modifier.height(8.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxWidth()
    ) {
        Button(onClick = {
            composeDialogType = ComposeDialogType.RADIO_DIALOG
        }) {
            Text("Radio Dialog")
        }

        Button(onClick = {
            composeDialogType = ComposeDialogType.TEXT_DIALOG
        }) {
            Text("Text Dialog")
        }
    }
}
