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
fun NewsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Noticias") },
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
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            @Composable
            fun MostrarNoticias() {
                val noticias = listOf(
                    "Un carro podador automatizado revoluciona el mantenimiento de jardines con inteligencia artificial.",
                    "Nueva tecnología de sensores permite al carro podador detectar obstáculos y ajustar su ruta de corte.",
                    "El carro podador automatizado reduce el consumo de energía en un 30% en comparación con modelos tradicionales.",
                    "Jardines sostenibles: el carro podador automático funciona con energía solar, ayudando al medio ambiente.",
                    "Empresas de paisajismo implementan carros podadores automatizados para ahorrar tiempo y recursos.",
                    "Usuarios destacan la facilidad de uso del nuevo carro podador automatizado controlado desde una app móvil.",
                    "Lanzamiento del carro podador con GPS integrado para asegurar cortes uniformes en todo el terreno.",
                    "La inteligencia artificial del carro podador detecta áreas de césped que necesitan más atención.",
                    "Estudios demuestran que el uso del carro podador automatizado mejora la calidad del césped al reducir errores humanos."
                )

                Column(modifier = Modifier.padding(16.dp)) {
                    noticias.forEachIndexed { index, noticia ->
                        Text(
                            text = "Noticia ${index + 1}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Descripción de la noticia ${index + 1}: $noticia",
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
