package com.lucas.damper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lucas.damper.ui.theme.DamperTheme
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale700
import com.lucas.damper.ui.theme.GrayScale900
import com.lucas.damper.ui.theme.azul100
import com.lucas.damper.ui.theme.azul200
import com.lucas.damper.ui.theme.azul300



@Composable
fun OnboardingThreeScreen(navController: NavHostController, modifier: Modifier = Modifier) { // Passando o Modifier corretamente

    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = GrayScale0,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)))
        ) {
            pushStringAnnotation(tag = "login", annotation = "Navigate to Detail Screen")
            append("Skip")
            pop()
        }
    }


    Column(modifier = modifier
        .fillMaxSize()
        .background(azul300))
    {

        Box(// Alinha o conteúdo dentro da Box ao centro
            contentAlignment = Alignment.Center, // Alinha o conteúdo ao centro
            modifier = Modifier
                .weight(0.6f)
        ) {
            // Círculo
            Box(
                modifier = Modifier
                    .absoluteOffset(x = (-80).dp, y = (-10).dp)
                    .size(500.dp) // Tamanho do círculo
                    .clip(RoundedCornerShape(250.dp)) // Cria um círculo com tamanho 150.dp de raio
                    .background(azul200) // Cor de fundo do círculo
            )
            Box(
                modifier = Modifier
                    .absoluteOffset(x = (-140).dp, y = (-20).dp)
                    .size(400.dp) // Tamanho do círculo
                    .clip(RoundedCornerShape(200.dp)) // Cria um círculo com tamanho 150.dp de raio
                    .background(azul100) // Cor de fundo do círculo
            )

            // Imagem sobreposta
            Image(
                painter = painterResource(id = R.drawable.onboardingthree),
                contentDescription = null,
                modifier = Modifier
                    .size(500.dp)
                    .align(Alignment.BottomCenter),
                contentScale = ContentScale.Crop
            )

            ClickableText(
                modifier = Modifier
                    .padding(top = 60.dp, end = 40.dp)
                    .align(alignment = Alignment.TopEnd),
                text = text,
                onClick = { offset ->
                    text.getStringAnnotations(tag = "login", start = offset, end = offset)
                        .firstOrNull()
                        ?.let {
                            navController.navigate("login")
                        }
                }
            )
        }
        Box(modifier = Modifier
            .weight(0.5f)
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                )
            )
            .background(GrayScale900)
        ){

            Column {
                Text(modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp, top = 60.dp)
                    .align(Alignment.CenterHorizontally),
                    text = "Oferecemos um serviço profissional a um preço amigável",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                    fontSize = 28.sp,
                    lineHeight = 40.sp,
                    textAlign = TextAlign.Center
                )

                Text(modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(start = 40.dp, end = 40.dp, top = 20.dp),
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                    lineHeight = 25.sp,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    color = GrayScale400,
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
                )

                Row(modifier = Modifier
                    .padding(top = 30.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                    horizontalArrangement = Arrangement.Center
                ){
                    Box(modifier = Modifier
                    ){
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(GrayScale700)
                                .align(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(color = Color.Transparent)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(modifier = Modifier
                    ){
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(GrayScale700)
                                .align(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(color = Color.Transparent)
                                .align(Alignment.Center)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Box(modifier = Modifier
                        .padding(start = 4.dp)
                    ){
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .clip(RoundedCornerShape(5.dp))
                                .background(azul200)
                                .align(Alignment.Center)
                        )
                        Box(
                            modifier = Modifier
                                .size(20.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .background(color = Color.Transparent)
                                .border(BorderStroke(4.dp, GrayScale700), RoundedCornerShape(10.dp))
                                .align(Alignment.Center)
                        )
                    }

                }
                Button(modifier = Modifier
                    .padding(start = 40.dp, end = 40.dp)
                    .fillMaxSize()
                    .wrapContentHeight(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = azul300
                    ),
                    shape = RoundedCornerShape(15.dp),
                    onClick = { navController.navigate("login") }
                ) {
                    Text(modifier = Modifier
                        .padding(top = 10.dp, bottom = 10.dp),
                        color = GrayScale0,
                        text = "Next",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
                    )
                }
            }
        }
    }
}
