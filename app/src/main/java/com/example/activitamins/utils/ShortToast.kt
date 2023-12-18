package com.example.activitamins.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable

@Composable
fun ShortToast(ctx: Context, message: String): Toast {
    return Toast.makeText(ctx, message, Toast.LENGTH_SHORT)
}