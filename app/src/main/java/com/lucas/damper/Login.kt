package com.lucas.damper

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lucas.damper.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel,
    modifier: Modifier = Modifier
) {
    val azulOpacity = azulOpacityInput.copy(alpha = 0.2f)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isFocusedEmail by remember { mutableStateOf(false) }
    var isFocusedSenha by remember { mutableStateOf(false) }

    val authState by authViewModel.authState.observeAsState(AuthState.Loading)
    val context = LocalContext.current

    // Navegar com base no estado de autenticação
    LaunchedEffect(authState) {
        when (authState) {
            is AuthState.Authenticated -> {
                navController.navigate("home") {
                    popUpTo("login") { inclusive = true }
                }
            }
            is AuthState.Error -> {
                Toast.makeText(context, (authState as AuthState.Error).message, Toast.LENGTH_SHORT).show()
            }
            else -> Unit
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayScale900)
            .padding(horizontal = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "Olá, bem-vindo de volta!",
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_medium))
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 40.dp),
            text = "Conecte-se para encontrar e contratar os melhores serviços locais perto de você!",
            color = GrayScale400,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_regular))
        )

        Text(
            fontSize = 16.sp,
            text = "Email"
        )
        Spacer(modifier = Modifier.height(10.dp))

        // INPUT EMAIL
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused }
        ) {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxSize(),
                value = email,
                onValueChange = { email = it },
                singleLine = true,
                placeholder = {
                    Text(
                        text = "Digite seu email",
                        style = TextStyle(fontSize = 16.sp, color = GrayScale400),
                    )
                },
                textStyle = TextStyle(fontSize = 16.sp),
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            fontSize = 16.sp,
            text = "Senha"
        )
        Spacer(modifier = Modifier.height(10.dp))

        // INPUT SENHA
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(if (isFocusedSenha) azulOpacity else GrayScale800)
                .onFocusChanged { focusState -> isFocusedSenha = focusState.isFocused },
            value = password,
            onValueChange = { password = it },
            singleLine = true,
            placeholder = {
                Text(
                    text = "Digite sua senha",
                    style = TextStyle(fontSize = 16.sp, color = GrayScale400),
                )
             },
            textStyle = TextStyle(fontSize = 16.sp),
            shape = RoundedCornerShape(16.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val iconRes = if (passwordVisible) R.drawable.visibility else R.drawable.visibilityoff
                val description = if (passwordVisible) "Ocultar senha" else "Mostrar senha"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(id = iconRes),
                        contentDescription = description,
                        modifier = Modifier.size(24.dp)
                    )
                }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = azul300,
                unfocusedBorderColor = GrayScale700
            )
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            modifier = Modifier.align(Alignment.End),
            onClick = { navController.navigate("forgotpassword") }
        ) {
            Text(
                text = "Esqueceu sua senha?",
                color = azul300,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        // BOTÃO SIGN IN
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = azul300),
            onClick = { authViewModel.login(email, password) },
            enabled = authState != AuthState.Loading
        ) {
            Text(
                text = "Sign In",
                color = GrayScale0,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(color = GrayScale700, thickness = 1.dp, modifier = Modifier.width(140.dp))
            Text(color = GrayScale400, text = "Ou continue com")
            Divider(color = GrayScale700, thickness = 1.dp, modifier = Modifier.width(140.dp))
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .border(BorderStroke(1.dp, GrayScale700), RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GrayScale800),
            onClick = { /* TODO: Google login action */ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.googleicon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 10.dp)
            )
            Text(
                text = "Sign in with Google",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .border(BorderStroke(1.dp, GrayScale700), RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GrayScale800),
            onClick = { /* TODO: Apple login action */ }
        ) {
            Image(
                painter = painterResource(id = R.drawable.appleicon),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .padding(end = 10.dp)
            )
            Text(
                text = "Sign in with Apple",
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )
        }
        Spacer(modifier = Modifier.height(100.dp))

        Row(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterVertically),
                text = "Já tem uma conta?",
                color = GrayScale0,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_medium))
            )

            Spacer(modifier = Modifier.width(10.dp))
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(
                        color = azul300,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)))) {
                    pushStringAnnotation(tag = "signup", annotation = "Navigate to Detail Screen")
                    append("signup")
                    pop()
                }
            }
            ClickableText(
                text = text,
                onClick = { offset ->
                    text.getStringAnnotations(tag = "signup", start = offset, end = offset)
                        .firstOrNull()
                        ?.let {
                            navController.navigate("signup")
                        }
                }
            )
        }
    }
}

