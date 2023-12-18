package com.example.activitamins.presentation.components.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormItem(
    label: String,
    inputVal: String,
    onInputChange: (it: String) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            label= { Text(text = label)},
            value = inputVal,
            onValueChange = onInputChange,
            placeholder = { Text(text = "Hiking") },
            maxLines = 2
        )
    }
}