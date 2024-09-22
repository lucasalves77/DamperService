package com.lucas.damper.Home

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lucas.damper.ui.theme.GrayScale700
import com.lucas.damper.ui.theme.GrayScale800
import com.lucas.damper.ui.theme.azul300
import com.lucas.damper.ui.theme.azulOpacityInput
import com.lucas.damperapp.MenuItem
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.input.ImeAction
import androidx.navigation.NavHostController
import com.lucas.damper.AuthState
import com.lucas.damper.AuthViewModel
import com.lucas.damper.R
import com.lucas.damper.ServicosRow
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale900


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(GrayScale900),
        contentPadding = PaddingValues(top = 20.dp), // Adiciona espaçamento entre os itens
    ) {
        item {
            header()
        }
        item {
            BarraPesquisa()
        }
    }
}


@Composable
fun header(){
    Row (
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {

        // FOTO DE PERFIL
        Image(modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(30.dp)),
            painter = painterResource(id = R.drawable.fotoperfil),
            contentDescription = null)

        Column{

            Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text(
                    color = GrayScale400,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_regular)),
                    fontSize = 16.sp,
                    text = "Ola,"
                )
                // NOME DO USUARIO
                Text(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_regular)),
                    color = GrayScale400,
                    text = " Aaron"
                )
            }

            Row {
                Icon(
                    tint = azul300,
                    painter = painterResource(id = R.drawable.locmapicon),
                    contentDescription = null)

                Spacer(modifier = Modifier.padding(4.dp))
                // LOCALIZACAO
                Text(
                    fontSize = 16.sp,
                    color = GrayScale0,
                    text = "Brooklym, New York"
                )
            }
        }

        // NOTIFICACAO
        Box(modifier = Modifier
            .size(60.dp)
            .clip(RoundedCornerShape(30.dp))
            .background(GrayScale700),
        ){
            Icon(modifier = Modifier
                .size(24.dp)
                .align(Alignment.Center),
                tint = GrayScale0,
                painter = painterResource(id = R.drawable.notificationicon),
                contentDescription = null)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraPesquisa() {

    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    var isFocusedSearch by remember { mutableStateOf(false) }
    val azulOpacity = azulOpacityInput.copy(alpha = 0.2f)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus() // Remove o foco ao clicar fora
                })
            }
    ) {
        // Barra de pesquisa
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 24.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(16.dp))
                .onFocusChanged { focusState ->
                    isFocusedSearch = focusState.isFocused
                }
                .background(
                    if (isFocusedSearch) azulOpacity else GrayScale800
                ),
            value = text,
            onValueChange = { newText -> text = newText },
            placeholder = { Text(text = "Digite seu email") },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = azul300,
                unfocusedBorderColor = GrayScale700,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() } // Esconde o teclado ao clicar em "Done"
            )
        )

        // Conteúdo adicional abaixo da barra de pesquisa
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 90.dp) // Ajuste o padding para posicionar o conteúdo corretamente
        ) {
            ServicosHomeCategory()
            SpecialOferts()
            ServicosHome()
        }
    }
}


@Composable
fun ServicosHomeCategory() {

    var selectedIndex by remember { mutableStateOf(0) }
    val azulOpacity = azul300.copy(alpha = 0.2f)
    val interactionSource = remember { MutableInteractionSource() }
    val menuItems = listOf(
        MenuItem(R.drawable.limpezaicon) { selectedIndex = 0 },
        MenuItem(R.drawable.contrucaoicon) { selectedIndex = 1 },
        MenuItem(R.drawable.culinariaicon) { selectedIndex = 2 },
        MenuItem(R.drawable.envioicon) { selectedIndex = 3 }
    )

    val labels = listOf("Limpeza", "Construção", "Culinária", "Envio")

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 32.dp, bottom = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 18.sp,
                text = "Serviços",
                color = GrayScale0,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )

            Text(
                text = "Ver todos",
                color = azul300,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_semibold))
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp,)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                menuItems.forEachIndexed { index, item ->
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(
                                    azulOpacity,
                                    shape = RoundedCornerShape(35.dp)
                                )
                                .clickable(
                                    interactionSource = interactionSource,
                                    indication = null
                                )

                                { item.onClick() },
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                modifier = Modifier.size(30.dp),
                                painter = painterResource(id = item.iconId),
                                contentDescription = null,
                                tint = azul300
                            )
                        }
                        Text(modifier = Modifier
                                .padding(top = 12.dp),
                            text = labels[index],
                            color = GrayScale0,
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.plusjakartasans_semibold))
                        )
                    }

                }
            }
        }
        Divider(modifier = Modifier
            .padding(top = 24.dp)
            .fillMaxWidth(),
            color = GrayScale700,
            thickness = 1.dp,
        )
    }
}


@Composable
fun SpecialOferts(){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 20.dp, end = 20.dp)

    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth().padding(bottom = 24.dp)
        ) {
            Text(
                fontSize = 18.sp,
                text = "Ofertas especiais",
                color = GrayScale0,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )

            Text(
                text = "Ver todos",
                color = azul300,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_semibold))
            )
        }

        Image(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp)),
            painter = painterResource(id = R.drawable.banner),
            contentDescription = null)
    }
}


@Composable
fun ServicosHome() {
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    val buttonActions = listOf(
        Pair("Limpeza") { println("Botão 1 clicado") },
        Pair("Reparos") { println("Botão 2 clicado") },
        Pair("Pinturas") { println("Botão 3 clicado") },
        Pair("Eletricista") { println("Botão 4 clicado") },
        Pair("Botão 5") { println("Botão 5 clicado") }
    )

    Column(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 32.dp, bottom = 24.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                fontSize = 18.sp,
                text = "Serviços",
                color = GrayScale0,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )

            Text(
                text = "Ver todos",
                color = azul300,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_semibold))
            )
        }

        ServicosRow(
            buttonActions = buttonActions,
            selectedIndex = selectedIndex,
            onButtonClick = { index ->
                selectedIndex = index
            }
        )

        val services = listOf(
            ServiceItem(
                title = "House Cleaning Service",
                description = "Includes dusting, vacuuming, etc.",
                location = "Brooklyn, NY",
                priceRange = "$100 - $200",
                imageResource = R.drawable.imageonbording1
            ),
            // Adicione mais ServiceItem aqui
        )

        CardServiceList(serviceItems = services)
    }
}


@Composable
fun CardService(
    title: String,
    description: String,
    location: String,
    priceRange: String,
    imageResource: Int
) {

    val azulOpacity = azul300.copy(alpha = 0.2f)

    Button(
        modifier = Modifier
            .height(180.dp)
            .padding(bottom = 16.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, GrayScale700), RoundedCornerShape(20.dp)),
        shape = RoundedCornerShape(20.dp),
        colors = ButtonDefaults.buttonColors(containerColor = GrayScale800),
        contentPadding = PaddingValues(0.dp),
        onClick = { /*TODO*/ }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
            ) {
            Image(
                modifier = Modifier
                    .weight(0.3f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(azul300),
                painter = painterResource(id = imageResource),
                contentDescription = null
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxSize()
                    .weight(0.7f)
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                    fontSize = 18.sp,
                    color = GrayScale0, text = title
                )
                Text(
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                    fontSize = 16.sp,
                    color = GrayScale400,
                    text = description)

                Row(
                    modifier = Modifier
                    .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row{
                        Icon(
                            painter = painterResource(id = R.drawable.locmapicon),
                            contentDescription = null,
                            tint = GrayScale400
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                            fontSize = 16.sp,
                            color = GrayScale400,
                            text = location
                        )
                    }

                    Box(
                        modifier = Modifier
                            .width(120.dp)
                            .height(40.dp)
                            .background(
                                azulOpacity,
                                shape = RoundedCornerShape(16.dp)
                            )
                    ){
                        Text(
                            modifier = Modifier
                                .align(Alignment.Center),
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                            fontSize = 16.sp,
                            color = azul300,
                            text = priceRange)
                    }


                    }
            }
        }
    }
}

@Composable
fun CardServiceList(serviceItems: List<ServiceItem>) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),

    ) {
        serviceItems.forEach { item ->
            CardService(
                title = item.title,
                description = item.description,
                location = item.location,
                priceRange = item.priceRange,
                imageResource = item.imageResource
            )
            CardService(
                title = item.title,
                description = item.description,
                location = item.location,
                priceRange = item.priceRange,
                imageResource = item.imageResource
            )
            CardService(
                title = item.title,
                description = item.description,
                location = item.location,
                priceRange = item.priceRange,
                imageResource = item.imageResource
            )
            CardService(
                title = item.title,
                description = item.description,
                location = item.location,
                priceRange = item.priceRange,
                imageResource = item.imageResource
            )
        }
    }
}


data class ServiceItem(
    val title: String,
    val description: String,
    val location: String,
    val priceRange: String,
    val imageResource: Int
)

