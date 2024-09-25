package com.lucas.damperapp


import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.samples.ModalLogout
import com.lucas.damper.AuthViewModel
import com.lucas.damper.ForgotPasswordScreen
import com.lucas.damper.Home.HomeScreen
import com.lucas.damper.LoginScreen
//import com.lucas.damper.Mensagens.ChatScreen
import com.lucas.damper.Mensagens.ProfileScreen
import com.lucas.damper.Mensagens.chatMessage
import com.lucas.damper.OnboardingOneScreen
import com.lucas.damper.OnboardingThreeScreen
import com.lucas.damper.OnboardingTwoScreen
import com.lucas.damper.Profile.dadosPessoais
import com.lucas.damper.SearchScreen
import com.lucas.damper.SignupScreen
import com.lucas.damper.SplashScreen

@Composable
fun MainLayout(navController: NavHostController,authViewModel: AuthViewModel) {
    // Get the current route
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf(
                    "splash",
                    "onboarding_one",
                    "onboarding_two",
                    "onboarding_three",
                    "login",
                    "signup",
                    "ModalLogout",
                    "forgotpassword")) {
                // Menu fica fixo na parte inferior de todas as telas, exceto splash e onboarding
                Menu(navController = navController)
            }
        }
    ) { innerPadding ->
        // Conteúdo da tela principal com o padding aplicado
        NavHost(
            navController = navController,
            startDestination = "splash",
            modifier = Modifier.padding(innerPadding) // Corrigido: Modifier.padding
        ) {
            composable("splash") { SplashScreen(navController,authViewModel) }
            composable("home") { HomeScreen(navController) }
            composable("search") { SearchScreen(navController,authViewModel) }
            composable("mensagem") { chatMessage(navController) }
            composable("profile") { ProfileScreen(navController,authViewModel) }
            composable("onboarding_one") { OnboardingOneScreen(navController) }
            composable("onboarding_two") { OnboardingTwoScreen(navController) }
            composable("onboarding_three") { OnboardingThreeScreen(navController) }
            composable("login") { LoginScreen(navController,authViewModel) }
            composable("signup") { SignupScreen(navController,authViewModel) }
            composable("ModalLogout") { ModalLogout(navController,authViewModel) }
            composable("forgotpassword") { ForgotPasswordScreen(navController,authViewModel, onPasswordResetSent = { navController.navigate("login") }) }
            composable("dadosPessoais") { dadosPessoais(navController) }
        }
    }
}
