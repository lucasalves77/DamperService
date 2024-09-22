package com.lucas.damper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.lucas.damper.ui.theme.DamperTheme
import com.lucas.damperapp.MainLayout
import com.lucas.damper.AuthViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DamperTheme {
                val navController = rememberNavController() // Inicializando o NavController
                val authViewModel: AuthViewModel = viewModel() // Pegando o ViewModel

                MainLayout(navController = navController, authViewModel = authViewModel)
            }
        }
    }
}
