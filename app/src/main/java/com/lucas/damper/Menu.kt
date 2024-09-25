package com.lucas.damperapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.lucas.damper.AuthState
import com.lucas.damper.AuthViewModel
import com.lucas.damper.R
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale500
import com.lucas.damper.ui.theme.GrayScale700
import com.lucas.damper.ui.theme.GrayScale900
import com.lucas.damper.ui.theme.azul300


data class MenuItem(val iconId: Int, val route: String, val onClick: () -> Unit)

@Composable
fun Menu(navController: NavHostController) {
    var selectedIndex by remember { mutableStateOf(0) }

    val currentRoute = navController.currentDestination?.route

    Row(
        modifier = Modifier
            .height(70.dp)
            .background(GrayScale900)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val menuItems = listOf(
            MenuItem(R.drawable.homeicon, "home") {
                selectedIndex = 0
                navigateToHome(navController, authViewModel = AuthViewModel()) // Chama a função de navegação para Home
            },
            MenuItem(R.drawable.searchicon, "search") {
                selectedIndex = 1
                navigateToSearch(navController)
            },
            MenuItem(R.drawable.calendaricon, "calendar") {
                selectedIndex = 2
                openCalendar(navController)
            },
            MenuItem(R.drawable.messageicon, "menssagens") {
                selectedIndex = 3
                openMessages(navController)
            },
            MenuItem(R.drawable.usericon, "profile") {
                selectedIndex = 4
                openUserProfile(navController)
            }
        )

    menuItems.forEachIndexed { index, item ->

            IconButton(modifier = Modifier
                .size(if(index == 2) 60.dp else 60.dp)
                .background(if(index == 2) azul300 else Color.Transparent, shape = CircleShape),
                onClick = item.onClick
            ) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = item.iconId),
                    contentDescription = null,
                    tint = if (index==2) GrayScale0 else if (item.route == currentRoute) GrayScale0 else GrayScale500
                )
            }
        }
    }
}


fun navigateToHome(navController: NavHostController,authViewModel: AuthViewModel) {
    navController.navigate("home") {
        popUpTo("home") { inclusive = true } // Garante que não volte para a mesma tela
        launchSingleTop = true // Evita múltiplas instâncias da mesma tela
    }
}

fun navigateToSearch(navController: NavHostController) {
    navController.navigate("search") {
        popUpTo("search") { inclusive = true } // Garante que não volte para a mesma tela
        launchSingleTop = true // Evita múltiplas instâncias da mesma tela
    }
}

fun openCalendar(navController: NavHostController) {
    navController.navigate("") {
        popUpTo("") { inclusive = true } // Garante que não volte para a mesma tela
        launchSingleTop = true // Evita múltiplas instâncias da mesma tela
    }
}

fun openMessages(navController: NavHostController) {
    navController.navigate("") {
        popUpTo("") { inclusive = true } // Garante que não volte para a mesma tela
        launchSingleTop = true // Evita múltiplas instâncias da mesma tela
    }
}

fun openUserProfile(navController: NavHostController) {
    navController.navigate("profile") {
        popUpTo("profile") { inclusive = true } // Garante que não volte para a mesma tela
        launchSingleTop = true // Evita múltiplas instâncias da mesma tela
    }
}