package com.example.proyectogms4.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectogms4.R
import com.example.proyectogms4.ui.theme.BackgroundButton
import com.example.proyectogms4.ui.theme.Black
import com.example.proyectogms4.ui.theme.Gray
import com.example.proyectogms4.ui.theme.Green
import com.example.proyectogms4.ui.theme.ShapeButton

@Preview(showBackground = true)
@Composable
fun InitialScreen(navigateToLogin: () -> Unit = {}, navigateToSignUp: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFFB8E994), Color(0xFF58B368))))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))

        // "Bienvenido!!" text with custom styling
        Text(
            "Bienvenido!!",
            color = Color(0xFF1D8348),
            fontSize = 42.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Display Logo
        Image(
            painter = painterResource(id = R.drawable.gmlogo),
            contentDescription = "",
            modifier = Modifier
                .size(180.dp)
                .clip(CircleShape)
                .border(4.dp, Color(0xFF1D8348), CircleShape)
        )

        Spacer(modifier = Modifier.weight(1f))

        // "Iniciar sesión" Button
        Button(
            onClick = { navigateToLogin() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3E4D7))
        ) {
            Text(text = "Iniciar sesión", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(8.dp))

        // "Registrarse" Button
        Button(
            onClick = { navigateToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFA3E4D7))
        ) {
            Text(text = "Registrarse", color = Color.Black, fontWeight = FontWeight.Bold)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // "Continue with Google" Button
        CustomButton(
            Modifier.clickable { /* Action for Google sign-in */ },
            painterResource(id = R.drawable.google), // Replace with the actual Google icon drawable
            "Continuar con Google"
        )

        Spacer(modifier = Modifier.weight(1f))


@Composable
fun CustomButton(modifier: Modifier, painter: Painter, title: String) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 32.dp)
            .background(Color.White, CircleShape)
            .border(2.dp, Color(0xFFA3E4D7), CircleShape),
        contentAlignment = Alignment.CenterStart
    ) {
        // Google Icon
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(start = 16.dp)
                .size(20.dp)
        )

        // Button Text
        Text(
            text = title,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}
