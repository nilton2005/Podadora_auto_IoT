package com.example.proyectogms4.presentation.home

package com.example.proyectogms4.presentation.climate

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectogms4.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClimateControlScreen(navController: NavController) {
    var temperature by remember { mutableStateOf(27) } // Estado para la temperatura
    var isOn by remember { mutableStateOf(true) } // Estado de encendido/apagado

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Control de Clima", color = Color(0xFFA5D6A7)) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Regresar", tint = Color(0xFFA5D6A7))
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF2E7D32) // Verde oscuro
                )
            )
        },
        containerColor = Color(0xFF1B5E20) // Fondo verde oscuro
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Iconos de funciones
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier.fillMaxWidth()
            ) {
                ClimateIconButton(iconId = R.drawable.ic_light, description = "Luz")
                ClimateIconButton(iconId = R.drawable.ic_music, description = "Música")
                ClimateIconButton(iconId = R.drawable.ic_cool, description = "Refrigeración")
                ClimateIconButton(iconId = R.drawable.ic_lightning, description = "Energía")
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Indicador de temperatura
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(200.dp)
                    .background(Color(0xFF66BB6A), shape = MaterialTheme.shapes.medium)
            ) {
                Text(
                    text = "$temperature°C",
                    style = MaterialTheme.typography.headlineMedium,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Controles de temperatura
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { if (temperature > 16) temperature-- }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_minus),
                        contentDescription = "Disminuir Temperatura",
                        tint = Color(0xFF388E3C)
                    )
                }
                IconButton(onClick = { isOn = !isOn }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_power),
                        contentDescription = "Encendido/Apagado",
                        tint = if (isOn) Color(0xFF388E3C) else Color.Gray
                    )
                }
                IconButton(onClick = { if (temperature < 30) temperature++ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_plus),
                        contentDescription = "Aumentar Temperatura",
                        tint = Color(0xFF388E3C)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Texto de estado
            Text(
                text = if (isOn) "Clima Activado" else "Clima Apagado",
                color = Color(0xFFA5D6A7),
                style = MaterialTheme.typography.bodyLarge
            )

            // Barra de navegación inferior
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .background(Color(0xFF2E7D32), shape = MaterialTheme.shapes.small)
                    .padding(8.dp)
            ) {
                IconButton(onClick = { /* Acción de configuración */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Configuración",
                        tint = Color(0xFFA5D6A7)
                    )
                }
                IconButton(onClick = { /* Acción de navegación a inicio */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Inicio",
                        tint = Color(0xFFA5D6A7)
                    )
                }
                IconButton(onClick = { /* Acción de navegación a clima */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_climate),
                        contentDescription = "Clima",
                        tint = Color(0xFFA5D6A7)
                    )
                }
                IconButton(onClick = { /* Acción de navegación a perfil */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Perfil",
                        tint = Color(0xFFA5D6A7)
                    )
                }
            }
        }
    }
}

@Composable
fun ClimateIconButton(iconId: Int, description: String) {
    IconButton(onClick = { /* Acción específica del botón */ }) {
        Icon(
            painter = painterResource(id = iconId),
            contentDescription = description,
            tint = Color(0xFFA5D6A7)
        )
    }
}
