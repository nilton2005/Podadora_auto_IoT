package com.example.proyectogms4.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.proyectogms4.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Panel de Control", color = Color(0xFFA5D6A7)) }, // Título en verde claro
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Regresar", tint = Color(0xFFA5D6A7)) // Flecha en verde claro
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
            Text(
                text = "Panel de Control",
                style = MaterialTheme.typography.headlineLarge,
                color = Color(0xFFA5D6A7) // Verde claro
            )
            Spacer(modifier = Modifier.height(20.dp))

            // Espacio para el mapa
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color(0xFF66BB6A), shape = MaterialTheme.shapes.medium) // Fondo verde intermedio
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_map_placeholder), // Imagen del mapa
                    contentDescription = "Vista de Mapa"
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Botones de control
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                IconButton(onClick = { /* Acción de pausa */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.gpause),
                        contentDescription = "Pausa",
                        tint = Color(0xFF388E3C) // Verde oscuro para icono
                    )
                }
                IconButton(onClick = { /* Acción de encendido/apagado */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.gpower),
                        contentDescription = "Encendido/Apagado",
                        tint = Color(0xFF388E3C) // Verde oscuro para icono
                    )
                }
                IconButton(onClick = { /* Acción de continuar */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.gplay),
                        contentDescription = "Continuar",
                        tint = Color(0xFF388E3C) // Verde oscuro para icono
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Barra de navegación inferior
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .background(Color(0xFF2E7D32), shape = MaterialTheme.shapes.small) // Fondo de la barra en verde oscuro
                    .padding(8.dp)
            ) {
                IconButton(onClick = { /* Acción de configuración */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_settings),
                        contentDescription = "Configuración",
                        tint = Color(0xFFA5D6A7) // Verde claro para icono
                    )
                }
                IconButton(onClick = { /* Acción de navegación a inicio */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_home),
                        contentDescription = "Inicio",
                        tint = Color(0xFFA5D6A7) // Verde claro para icono
                    )
                }
                IconButton(onClick = { /* Acción de navegación a la cámara */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_camera),
                        contentDescription = "Cámara",
                        tint = Color(0xFFA5D6A7) // Verde claro para icono
                    )
                }
                IconButton(onClick = { /* Acción de navegación a perfil */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = "Perfil",
                        tint = Color(0xFFA5D6A7) // Verde claro para icono
                    )
                }
            }
        }
    }
}


