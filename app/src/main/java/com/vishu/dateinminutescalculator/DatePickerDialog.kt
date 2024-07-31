package com.vishu.dateinminutescalculator

import androidx.compose.runtime.Composable
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit


@Composable
fun DatePickerDialog(
    context: android.content.Context,
    onDateSelected: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    val calendar = Calendar.getInstance()
    android.app.DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            val date = "$dayOfMonth/${month + 1}/$year"
            onDateSelected(date)
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    ).apply {
        setOnDismissListener { onDismissRequest() }
    }.show()
}

fun calculateAgeInMinutes(date: String): Long {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
    val birthDate = sdf.parse(date) ?: return 0
    val currentDate = Date()

    return TimeUnit.MILLISECONDS.toMinutes(currentDate.time - birthDate.time)
}
