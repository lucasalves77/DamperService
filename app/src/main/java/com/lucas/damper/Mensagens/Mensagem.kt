package com.lucas.damper.Mensagens


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.lucas.damper.SignupScreen
import com.lucas.damper.auth.signin.SignInScreen
import com.lucas.damper.auth.signup.SignUpScreen


@Composable
fun chatMessage(navController: NavController){
    Surface(modifier = Modifier.fillMaxSize()
    ) {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()




        NavHost(navController = navController, startDestination = "login") {

            composable("login") {
                SignInScreen(navController)
            }
            composable("signup") {
                SignUpScreen(navController)
            }
        }
    }
}
