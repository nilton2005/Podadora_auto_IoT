package com.example.proyectogms4.presentation.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Configuración del Carrito Podador") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "Regresar")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {
            // Título
            Text("Opciones de Configuración", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.height(16.dp))

            // Configuración de Velocidad
            SettingItem(label = "Velocidad de Corte", value = "10 km/h", onClick = { /* Lógica para ajustar velocidad */ })

            Spacer(modifier = Modifier.height(8.dp))

            // Configuración de Modo de Operación
            SettingItem(label = "Modo de Operación", value = "Automático", onClick = { /* Lógica para cambiar modo */ })

            Spacer(modifier = Modifier.height(8.dp))

            // Configuración de Rango de Trabajo
            SettingItem(label = "Rango de Trabajo", value = "50 metros", onClick = { /* Lógica para ajustar rango */ })

            Spacer(modifier = Modifier.height(8.dp))

            // Conexión a la Red
            SettingItem(label = "Conexión Wi-Fi", value = "Conectado", onClick = { /* Lógica para gestionar conexión */ })

            Spacer(modifier = Modifier.height(8.dp))

            // Configuración de Batería
            SettingItem(label = "Nivel de Batería", value = "80%", onClick = { /* Lógica para revisar nivel de batería */ })

            Spacer(modifier = Modifier.height(8.dp))

            // Activar o Desactivar el Carrito
            SettingItem(label = "Estado del Carrito", value = "Activo", onClick = { /* Lógica para activar/desactivar */ })
        }
    }
}

@Composable
fun SettingItem(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onClick),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label, style = MaterialTheme.typography.bodyLarge)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
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


