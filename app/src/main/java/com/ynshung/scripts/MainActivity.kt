package com.ynshung.scripts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.ynshung.scripts.ui.MenuScreen
import com.ynshung.scripts.ui.theme.ScriptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScriptsTheme {
                // A surface container using the 'background' color from the theme
                MenuScreen()
            }
        }
    }
}
