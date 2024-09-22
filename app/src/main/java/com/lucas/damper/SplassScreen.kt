package com.lucas.damper


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale900
import com.lucas.damper.ui.theme.azul300
import kotlinx.coroutines.delay




@Composable
fun SplashScreen(navController: NavController, authViewModel: AuthViewModel) {
    // Observa o estado de autenticação do ViewModel
    val authState by authViewModel.authState.observeAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayScale900),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(id = R.drawable.polygonbacklogo),
                    contentDescription = null
                )

                Icon(
                    painter = painterResource(id = R.drawable.painticonlogo),
                    contentDescription = null,
                    tint = GrayScale0
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    fontSize = 24.sp,
                    color = azul300,
                    text = "Damper"
                )
                Text(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_regular)),
                    color = azul300,
                    text = "Service"
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CircularProgressIndicator(
                color = azul300,
                modifier = Modifier.size(50.dp)
            )
        }
    }

    LaunchedEffect(authState) {
        delay(2000) // Delay de 2 segundos
        when (authState) {
            is AuthState.Authenticated -> {
                // Navega para a tela Home se estiver autenticado
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            is AuthState.Unauthenticated -> {
                // Navega para a tela de Onboarding se não estiver autenticado
                navController.navigate("onboarding_one") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            else -> {
                // Caso Loading ou Erro, podemos mostrar algo ou apenas aguardar
            }
        }
    }
}

