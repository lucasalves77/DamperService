package com.lucas.damper.Mensagens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.samples.ModalLogout
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.lucas.damper.AuthViewModel
import com.lucas.damper.R
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale300
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale900

@Composable
fun ProfileScreen(navController: NavHostController, authViewModel: AuthViewModel) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayScale900),
    ) {
        Row(
            modifier = Modifier
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
        ) {
            Image(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(60.dp)
                    .clip(CircleShape),
                painter = painterResource(id = R.drawable.fotoperfil),
                contentDescription = null
            )

            Column {
                Text(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                    color = GrayScale0,
                    text = "Lucas Alves"
                )

                Text(
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_regular)),
                    color = GrayScale400,
                    text = "aaronramsdale@gmail.com"
                )
            }
        }

        listaServicosDomesticos(navController = navController)

        ModalLogout(authViewModel)

    }
}

@Composable
fun listaServicosDomesticos(navController: NavController) {
    Column(modifier = Modifier
        .padding(top = 30.dp)
    ) {
        // Categoria Limpeza
        nomeCategoriaDomesticos(nome = "Informações pessoais")
        listOf(
            "Dados pessoais" to R.drawable.usericon,
            "Conta de pagamento" to R.drawable.walleticon,
            "Segurança da conta" to R.drawable.shieldicon,
        ).forEach { (item, icon) ->
            listaCardDomesticos(
                nameItem = item,
                iconItemLeft = icon,
                iconItemRight = R.drawable.chevronrighticon,
                onClick = {
                    when (item) {
                        "Dados pessoais" -> navController.navigate("dadosPessoais")
                        "Conta de pagamento" -> navController.navigate("contaPagamentoScreen")
                        "Segurança da conta" -> navController.navigate("segurancaContaScreen")
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        // Categoria Geral
        nomeCategoriaDomesticos(nome = "Geral")
        listOf(
            "Linguagem" to R.drawable.worldicon,
            "Notificações push" to R.drawable.notificationicon,
            "Limpar cache" to R.drawable.trashicon
        ).forEach { (item, icon) ->
            listaCardDomesticos(
                nameItem = item,
                iconItemLeft = icon,
                iconItemRight = R.drawable.chevronrighticon,
                onClick = {
                    when (item) {
                        "Linguagem" -> navController.navigate("linguagemScreen")
                        "Notificações push" -> navController.navigate("notificacoesScreen")
                        "Limpar cache" -> navController.navigate("limparCacheScreen")
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }

        // Categoria Sobre
        nomeCategoriaDomesticos(nome = "Sobre")
        listOf(
            "Central de Ajuda" to R.drawable.helpicon,
            "Política de Privacidade" to R.drawable.lockicon,
            "Sobre o aplicativo" to R.drawable.infoicon,
            "Termos e Condições" to R.drawable.gavelicon
        ).forEach { (item, icon) ->
            listaCardDomesticos(
                nameItem = item,
                iconItemLeft = icon,
                iconItemRight = R.drawable.chevronrighticon,
                onClick = {
                    when (item) {
                        "Central de Ajuda" -> navController.navigate("ajudaScreen")
                        "Política de Privacidade" -> navController.navigate("politicaPrivacidadeScreen")
                        "Sobre o aplicativo" -> navController.navigate("sobreAppScreen")
                        "Termos e Condições" -> navController.navigate("termosCondicoesScreen")
                    }
                }
            )
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
fun nomeCategoriaDomesticos(
    nome: String,
){
    Text(
        modifier = Modifier
            .padding(top = 16.dp, start = 24.dp, bottom = 20.dp),
        fontSize = 18.sp,
        text = nome,
        color = GrayScale0,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily(Font(R.font.plusjakartasans_medium))
    )
}

@Composable
fun listaCardDomesticos(
    nameItem: String,
    iconItemLeft: Int,
    iconItemRight: Int,
    onClick: () -> Unit // Adicione a função onClick
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
            .clickable(onClick = onClick), // Torna o item clicável
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícone à esquerda
        Icon(
            painter = painterResource(id = iconItemLeft),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp), // Tamanho do ícone
            tint = GrayScale0
        )

        // Texto do item
        Text(
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
            text = nameItem,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp), // Espaçamento entre o ícone e o texto
            color = GrayScale0
        )

        // Ícone à direita
        Icon(
            painter = painterResource(id = iconItemRight),
            contentDescription = null,
            modifier = Modifier
                .size(30.dp),// Tamanho do ícone
            tint = GrayScale300
        )
    }
}


