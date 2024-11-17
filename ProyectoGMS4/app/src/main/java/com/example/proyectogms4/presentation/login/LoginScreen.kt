package com.example.proyectogms4.presentation.login
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth
import android.util.Log
import androidx.compose.foundation.shape.RoundedCornerShape

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(auth:   navigateToLogin: () -> Unit = {},
                navigateToSignUp: () -> Unit = {},
                navigateToHome: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFF2DF)) // Fondo verde claro como en la imagen
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título de login
        Text(
            text = "LOGIN",
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo de texto para el email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("EMAIL", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF), // Fondo del campo de texto
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                //textColor = Color.Black
            )
        )

        Spacer(Modifier.height(16.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("PASSWORD", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                // textColor = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation() // Para ocultar el texto de la contraseña
        )

        Spacer(Modifier.height(16.dp))

        // Texto de "¿Olvidaste tu contraseña?"
        Text(
            text = "¿Olvidaste tu contraseña?",
            color = Color.Black,
            fontSize = 14.sp,
            modifier = Modifier.align(Alignment.End)
        )

        Spacer(Modifier.height(32.dp))

        // Botón de login
        Button(
            onClick = {
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        navigateToHome()
                        Log.i("yo", "LOGIN ok")
                    } else {
                        navigateToHome()
                        Log.i("yo", "LOGIN no")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB7E4C7) // Color verde claro del botón como en la imagen
            ),
            shape = RoundedCornerShape(24.dp) // Forma redondeada del botón
        ) {
            Text(text = "LOGIN", color = Color.Black)
        }
    }
}
