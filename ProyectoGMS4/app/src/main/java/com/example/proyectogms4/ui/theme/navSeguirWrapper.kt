package com.example.proyectogms4.ui.theme

import androidx.compose.runtime.*

@Composable
fun MyApp() {
    var currentScreen by remember { mutableStateOf(0) }

    val screens = listOf(
        ScreenData(
            imageResId = R.drawable.ic_image1,
            title = "Fácil de Usar",
            description = "Nuestra tecnología es intuitiva y muy segura, permitiendo controlar cada función sin complicaciones y con total confianza."
        ),
        ScreenData(
            imageResId = R.drawable.ic_image2,
            title = "Jardín Inteligente",
            description = "Diseño seguro para un jardín automatizado que cuida de tus plantas mientras tú te relajas, brindando tranquilidad y control total."
        ),
        ScreenData(
            imageResId = R.drawable.ic_image3,
            title = "Control Remoto",
            description = "Con un sistema remoto extremadamente seguro, puedes gestionar y supervisar el funcionamiento en cualquier momento y desde cualquier lugar, sin preocupaciones."
        )
    )

    ScreenCard(
        data = screens[currentScreen],
        onNextClick = {
            currentScreen = (currentScreen + 1) % screens.size
        }
    )
}

@Composable
fun ScreenCard(data: ScreenData, onNextClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFB2E0A1))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = data.imageResId),
                contentDescription = null,
                modifier = Modifier.size(80.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = data.title, fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = data.description, fontSize = 14.sp, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onNextClick,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF9ACD88))
            ) {
                Text("Siguiente")
            }
        }
    }
}

data class ScreenData(val imageResId: Int, val title: String, val description: String)
