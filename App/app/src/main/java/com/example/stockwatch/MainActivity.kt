package com.example.stockwatch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.stockwatch.ui.theme.StockWatchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StockWatchTheme {
                // La superficie (Surface) ocupa toda la pantalla y establece un color de fondo.
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    // Se utiliza un estado para almacenar el valor del campo de texto del correo electrónico.
    var email by remember { mutableStateOf(TextFieldValue("")) }

    // Column organiza sus elementos hijos en una secuencia vertical.
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa todo el espacio disponible.
            .padding(16.dp), // Añade un relleno alrededor de la columna.
        horizontalAlignment = Alignment.CenterHorizontally, // Centra los elementos horizontalmente.
        verticalArrangement = Arrangement.SpaceBetween // Distribuye el espacio verticalmente.
    ) {
        // Espaciador para empujar el contenido principal hacia abajo desde la barra de estado.
        Spacer(modifier = Modifier.height(64.dp))

        // Contenedor principal para el formulario de inicio de sesión.
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f) // Ocupa el espacio restante.
        ) {
            Text(
                text = "StockWatch",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 64.dp)
            )

            Text(
                text = "Create an account",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "Enter your email to sign up for this app",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Campo de texto para el correo electrónico.
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("email@domain.com") },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Botón de continuar.
            Button(
                onClick = { /* TODO: Lógica para continuar con el correo */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(text = "Continue", color = Color.White)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Divisor "or".
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider(modifier = Modifier.weight(1f))
                Text(
                    text = "or",
                    modifier = Modifier.padding(horizontal = 8.dp),
                    color = Color.Gray
                )
                Divider(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para continuar con Google.
            Button(
                onClick = { /* TODO: Lógica para el inicio de sesión con Google */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF2F2F2))
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    // Se necesitaría añadir el recurso del icono de Google a la carpeta 'drawable'.
                    // Por ahora, se usa un marcador de posición.
                    // Icon(
                    //     painter = painterResource(id = R.drawable.ic_google_logo),
                    //     contentDescription = "Google logo",
                    //     modifier = Modifier.size(24.dp)
                    // )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Continue with Google", color = Color.Black)
                }
            }
        }

        // Texto legal en la parte inferior de la pantalla.
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "By clicking continue, you agree to our",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
            // Se usa ClickableText si se desea que los enlaces sean funcionales.
            ClickableText(
                text = AnnotatedString("Terms of Service and Privacy Policy"),
                style = MaterialTheme.typography.bodySmall.copy(textAlign = TextAlign.Center, color = Color.Gray, fontWeight = FontWeight.Bold),
                onClick = { offset ->
                    // TODO: Lógica para abrir los enlaces de Términos de Servicio y Política de Privacidad.
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

// Vista previa para visualizar el diseño en Android Studio.
@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    StockWatchTheme {
        SignUpScreen()
    }
}