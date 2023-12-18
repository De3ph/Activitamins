package com.example.activitamins.presentation.components.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePhoto(
    photo: Int,
    label: String
) {
    Column {
        Image(
            painter = painterResource(id = photo),
            contentScale = ContentScale.Crop,
            contentDescription = "profile photo"
        )
        Row(
            Modifier.padding(
                bottom = 10.dp
            ).fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = label, style = MaterialTheme.typography.titleLarge)
        }
    }
}