package com.example.activitamins.utils

import android.icu.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun DateFormatter(
    date: Date
): String {

    return SimpleDateFormat("dd/MM/yyyy hh:mm", Locale.forLanguageTag("tr")).format(date)
}