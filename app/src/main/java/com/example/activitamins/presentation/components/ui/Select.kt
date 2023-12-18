package com.example.activitamins.presentation.components.ui

import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun Select() {

    var isOpen by remember {
        mutableStateOf<Boolean>(false)
    }

    var selectedOptionText by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(expanded = isOpen, onExpandedChange = { isOpen = it }) {

        TextField(
            modifier = Modifier.menuAnchor(),
            value = selectedOptionText,
            onValueChange = {},
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = isOpen)
            }
        )

        ExposedDropdownMenu(expanded = isOpen, onDismissRequest = { isOpen = false }) {

            DropdownMenuItem(onClick = { selectedOptionText = "item1" }) {
                Text(text = "Item")
            }
            DropdownMenuItem(onClick = { selectedOptionText = "item2" }) {
                Text(text = "Item")
            }
            DropdownMenuItem(onClick = { selectedOptionText = "item3" }) {
                Text(text = "Item")
            }
        }
    }
}