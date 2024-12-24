// MainScreen.kt
// File type -> File

package com.example.navigasisederhana.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun MainScreen(onNavigate: (String) -> Unit) {

    var message by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ini adalah Main Screen",fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        TextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Masukkan Pesan") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        Button(onClick = { onNavigate(message) }) {
            Text(text = "Pergi ke Second Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen({})
}