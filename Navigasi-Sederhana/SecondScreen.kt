// SecondScreen.kt
// File type -> File

package com.example.navigasisederhana.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    message: String,
    onNavigate: () -> Unit,
    onNavigateBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Ini adalah Second Screen",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Text(
            text = "Pesan: $message",
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
        Button(onClick = onNavigate) {
            Text(text = "Pergi ke Third Screen")
        }
        Button(onClick = onNavigateBack) {
            Text(text = "Kembali ke Main Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    SecondScreen(
        message = "",
        onNavigate={},
        onNavigateBack={})
}