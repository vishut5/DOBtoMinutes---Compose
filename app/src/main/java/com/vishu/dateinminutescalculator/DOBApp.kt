package com.vishu.dateinminutescalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DOBApp() {
    var selectedDate by remember { mutableStateOf<String?>(null) }
    var ageInMinutes by remember { mutableStateOf<Long?>(null) }
    var showDialog by remember { mutableStateOf(false) }

    if (showDialog) {
        DatePickerDialog(
            context = LocalContext.current,
            onDateSelected = { date ->
                selectedDate = date
                ageInMinutes = calculateAgeInMinutes(date)
                showDialog = false
            },
            onDismissRequest = {
                showDialog = false
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Date to Minutes Calculator")
                },
                backgroundColor = Color(0xFFFBC02D), // Yellow color
                contentColor = Color.White
            )
        },
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFFE0E0E0))
                    .padding(top = 12.dp),
                contentAlignment = Alignment.TopCenter
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "CALCULATE YOUR",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "AGE",
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.Red,
                            modifier = Modifier.padding(bottom = 16.dp),

                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        Text(
                            text = "IN MINUTES",
                            fontSize = 30.sp,
                            color = Color.Red,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)

                        )
                    }
                    Spacer(modifier = Modifier.height(150.dp))

                    Button(
                        onClick = { showDialog = true },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color(0xFFFBC02D),
                            contentColor = Color.White
                        )
                    ) {
                        Text("SELECT DATE")
                    }

                    Spacer(modifier = Modifier.height(150.dp))

                    Text(text = "Selected Date: ${selectedDate ?: "Not selected"}")

                    Spacer(modifier = Modifier.height(50.dp))

                    Text(text = "Age in minutes: ${ageInMinutes ?: "Not calculated"}")
                }
            }
        }
    )
}
