package com.example.proyectogms4.presentation.signup
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectogms4.R
import com.google.firebase.auth.FirebaseAuth
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(auth: FirebaseAuth, navController: NavController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFF2DF)) // Fondo verde claro
            .padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Título de registrarse
        Text(
            text = "Registrarse",
            color = Color.Black,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Campo de texto para el nombre
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nombre", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
            )
        )

        Spacer(Modifier.height(8.dp))

        // Campo de texto para el email
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
               // textColor = Color.Black
            )
        )

        Spacer(Modifier.height(8.dp))

        // Campo de texto para la contraseña
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                // TextColor = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(8.dp))

        // Campo de texto para confirmar la contraseña
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirm Password", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                // textColor = Color.Black
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(Modifier.height(8.dp))

        // Campo de texto para el número de teléfono
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Number", color = Color.Black) },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                containerColor = Color(0xFFDFF2DF),
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                // textColor = Color.Black
            )
        )

        Spacer(Modifier.height(16.dp))

        // Botones de registro social
        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { /* Acción de Google */ }) {
                Image(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Google",
                    modifier = Modifier.size(48.dp)
                )
            }
            IconButton(onClick = { /* Acción de Facebook */ }) {
                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Facebook",
                    modifier = Modifier.size(48.dp)
                )
            }
        }

        Spacer(Modifier.height(24.dp))

        // Botón de registro
        Button(
            onClick = {
                if (password == confirmPassword) {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.i("Registro", "Registro exitoso")
                        } else {
                            Log.i("Registro", "Error en el registro")
                            navController.navigate("home")

                        }
                    }
                } else {
                    Log.i("Registro", "Las contraseñas no coinciden")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFB7E4C7) // Color verde claro del botón
            ),
            shape = RoundedCornerShape(24.dp)
        ) {
            Text(text = "Registro", color = Color.Black, fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}
