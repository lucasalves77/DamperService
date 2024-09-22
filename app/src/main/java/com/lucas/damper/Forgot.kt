package com.lucas.damper


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ForgotPasswordScreen(navController: NavController,
    authViewModel: AuthViewModel,
    onPasswordResetSent: () -> Unit // Navegar ou exibir mensagem após sucesso
) {
    var email by remember { mutableStateOf(TextFieldValue("")) }
    val authState by authViewModel.authState.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Reset Password")

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                authViewModel.sendPasswordResetEmail(email.text)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Send Reset Email")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (authState) {
            is AuthState.Loading -> CircularProgressIndicator()
            is AuthState.PasswordResetEmailSent -> {
                Text("Password reset email sent!")
                onPasswordResetSent() // Aqui você pode navegar ou exibir uma mensagem
            }
            is AuthState.Error -> {
                val error = (authState as AuthState.Error).message
                Text(text = "Error: $error")
            }
            else -> Unit
        }
    }
}

