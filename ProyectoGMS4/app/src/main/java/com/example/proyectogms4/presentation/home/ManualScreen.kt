package com.example.proyectogms4.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ManualScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Manual de Uso") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Regresar")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(4) { index ->
                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Capítulo ${index + 1}: ${
                                when (index) {
                                    0 -> "Introducción al Carrito Podador"
                                    1 -> "Configuración Inicial y Conexión"
                                    2 -> "Operación y Controles del Carrito"
                                    3 -> "Mantenimiento y Resolución de Problemas"
                                    else -> "Capítulo ${index + 1}"
                                }
                            }",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = when (index) {
                                0 -> "Este capítulo brinda una visión general del carrito podador, sus características y ventajas de uso."
                                1 -> "En este capítulo aprenderás a configurar el carrito, conectarlo a la aplicación y prepararlo para el uso."
                                2 -> "Aquí se explican los controles del carrito, tanto para el modo autónomo como el control manual a distancia."
                                3 -> "Consejos sobre mantenimiento preventivo, limpieza, y solución de problemas comunes para un mejor rendimiento."
                                else -> "Contenido del capítulo ${index + 1}"
                            },
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }

            }
        }
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFB7E4C7) // Color verde claro del botón como en la imagen
        ),
        shape = RoundedCornerShape(24.dp) // Forma redondeada del botón
        )
    }
}