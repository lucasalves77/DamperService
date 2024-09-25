package com.lucas.damper

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale800
import com.lucas.damper.ui.theme.azul300

@Composable
fun ServicosRow(
    buttonActions: List<Pair<String, () -> Unit>>,
    selectedIndex: Int?,
    onButtonClick: (Int) -> Unit
) {
    LazyRow(
        modifier = Modifier
            .padding(top = 24.dp, bottom = 16.dp)
    ) {
        itemsIndexed(buttonActions) { index, (text, onClick) ->
            Button(
                onClick = {
                    onButtonClick(index) // Atualiza o índice do botão selecionado
                    onClick() // Executa a função associada ao botão
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedIndex == index) azul300 else GrayScale800
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp) // Adiciona um espaço entre os botões
                    .height(40.dp)
            ) {
                Text(
                    fontSize = 14.sp,
                    text = text,
                    color = if (selectedIndex == index) Color.White else GrayScale400
                )
            }
        }
    }
}
