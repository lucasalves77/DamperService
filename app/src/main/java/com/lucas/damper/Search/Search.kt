package com.lucas.damper

import BarraSearch
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.lucas.damper.Search.ListService
import com.lucas.damper.ui.theme.GrayScale900

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController, authViewModel: AuthViewModel) {

    LazyColumn(modifier = Modifier
            .background(GrayScale900)
            .fillMaxSize(),
        contentPadding = PaddingValues(start = 20.dp, end = 20.dp, top = 20.dp),
    ) {
        item {
            TopBar(navController)
        }

        item {
            BarraSearch()
        }

        item{
            var selectedIndex by remember { mutableStateOf<Int?>(null) }

            val buttonActions = listOf(
                Pair("Limpeza") { println("Botão Limpeza clicado") },
                Pair("Reparos") { println("Botão Reparos clicado") },
                Pair("Pinturas") { println("Botão Pinturas clicado") },
                Pair("Eletricista") { println("Botão Eletricista clicado") },
                Pair("Botão 5") { println("Botão 5 clicado") }
            )

            ServicosRow(
                buttonActions = buttonActions,
                selectedIndex = selectedIndex,
                onButtonClick = { index ->
                    selectedIndex = index
                }
            )
        }

        item {
            ListService()
        }

    }
}
