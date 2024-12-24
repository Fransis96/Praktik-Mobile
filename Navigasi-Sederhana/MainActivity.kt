// MainActivity.kt

package com.example.navigasisederhana

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.navigasisederhana.screens.MainScreen
import com.example.navigasisederhana.screens.SecondScreen
import com.example.navigasisederhana.screens.ThirdScreen
import com.example.navigasisederhana.ui.theme.NavigasiSederhanaTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavigasiSederhanaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyApp(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun MyApp(innerPadding: Modifier) {

    // Mengelola state navigasi
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }
    var messageToSend by remember { mutableStateOf("")}

    when (currentScreen) {
        Screen.Main -> MainScreen (
            onNavigate = { message ->
                messageToSend = message
                currentScreen = Screen.Second
            }
        )
        Screen.Second -> SecondScreen (
            message = messageToSend,
            onNavigate = { currentScreen = Screen.Third },
            onNavigateBack = { currentScreen = Screen.Main }
        )
        Screen.Third -> ThirdScreen (
            onNavigateBack = { currentScreen = Screen.Second }
        )
    }
}
enum class Screen {
    Main, Second, Third
}