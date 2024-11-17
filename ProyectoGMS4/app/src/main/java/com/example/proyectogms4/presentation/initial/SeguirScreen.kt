package com.example.proyectogms4.presentation.initial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD0F0C0)) // Light green background
    ) {
        ScreenCard(
            imageResId = R.drawable.ic_image1,
            title = "Fácil de Usar",
            description = "Nuestra tecnología es intuitiva y muy segura, permitiendo controlar cada función sin complicaciones y con total confianza."
        )
        Spacer(modifier = Modifier.height(16.dp))
        ScreenCard(
            imageResId = R.drawable.ic_image2,
            title = "Jardín Inteligente",
            description = "Diseño seguro para un jardín automatizado que cuida de tus plantas mientras tú te relajas, brindando tranquilidad y control total."
        )
        Spacer(modifier = Modifier.height(16.dp))
        ScreenCard(
            imageResId = R.drawable.ic_image3,
            title = "Control Remoto",
            description = "Con un sistema remoto extremadamente seguro, puedes gestionar y supervisar el funcionamiento en cualquier momento y desde cualquier lugar, sin preocupaciones."
        )
    }
}

@Composable
fun ScreenCard(imageResId: Int, title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2E0A1)) // Medium green color
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = description, fontSize = 14.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { /* No action for now */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9ACD88)) // Darker green for button
            ) {
                Text("Siguiente")
            }
        }
    }
}
