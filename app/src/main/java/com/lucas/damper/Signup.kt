package com.lucas.damper

import android.widget.Toast
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
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lucas.damper.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen(navController: NavHostController, authViewModel: AuthViewModel, modifier: Modifier = Modifier) {
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("home")
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT
            ).show()
            else -> Unit
        }
    }

    val azulOpacity = azulOpacityInput.copy(alpha = 0.2f)
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var dataNascimento by remember { mutableStateOf("") }
    var numeroTelefone by remember { mutableStateOf("") }
    var rua by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var isFocusedEmail by remember { mutableStateOf(false) }
    var isFocusedNome by remember { mutableStateOf(false) }
    var isFocusedDataNascimento by remember { mutableStateOf(false) }
    var isFocusedNumeroTelefone by remember { mutableStateOf(false) }
    var isFocusedRua by remember { mutableStateOf(false) }
    var isFocusedPassword by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayScale900)
            .padding(start = 20.dp, end = 20.dp)
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
            text = "Hi, Welcome Back!"
        )
        Text(
            modifier = Modifier.padding(top = 20.dp, bottom = 40.dp),
            color = GrayScale0,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
            text = "Lorem Ipsum is simply dummy text of the printing and typesetting industry."
        )

        // Input fields
        InputField(
            label = "Nome completo",
            value = nome,
            onValueChange = { nome = it },
            isFocused = isFocusedNome,
            onFocusChange = { isFocusedNome = it },
            placeholder = "Digite seu nome completo",
            azulOpacity = azulOpacity,
            grayScale = GrayScale800
        )

        InputField(
            label = "Data de nascimento",
            value = dataNascimento,
            onValueChange = { dataNascimento = it },
            isFocused = isFocusedDataNascimento,
            onFocusChange = { isFocusedDataNascimento = it },
            placeholder = "Digite sua data de nascimento",
            azulOpacity = azulOpacity,
            grayScale = GrayScale800
        )

        InputField(
            label = "Número de telefone",
            value = numeroTelefone,
            onValueChange = { numeroTelefone = it },
            isFocused = isFocusedNumeroTelefone,
            onFocusChange = { isFocusedNumeroTelefone = it },
            placeholder = "Digite seu número de telefone",
            azulOpacity = azulOpacity,
            grayScale = GrayScale800
        )

        InputField(
            label = "Rua",
            value = rua,
            onValueChange = { rua = it },
            isFocused = isFocusedRua,
            onFocusChange = { isFocusedRua = it },
            placeholder = "Digite sua rua",
            azulOpacity = azulOpacity,
            grayScale = GrayScale800
        )

        InputField(
            label = "Email",
            value = email,
            onValueChange = { email = it },
            isFocused = isFocusedEmail,
            onFocusChange = { isFocusedEmail = it },
            placeholder = "Digite seu email",
            azulOpacity = azulOpacity,
            grayScale = GrayScale800
        )

        // Password input field
        Text(text = "Senha")
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .onFocusChanged { focusState -> isFocusedPassword = focusState.isFocused }
                .clip(RoundedCornerShape(16.dp))
                .background(if (isFocusedPassword) azulOpacity else GrayScale800),
            textStyle = TextStyle(fontSize = 24.sp),
            value = password,
            onValueChange = { password = it },
            placeholder = {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart)
                ){
                    Text(
                        text = "Digite sua senha",
                        style = TextStyle(fontSize = 16.sp, color = GrayScale400),
                    )}
            },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = azul300,
                unfocusedBorderColor = GrayScale700
            ),
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
            }
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = azul300),
            onClick = { authViewModel.signup(email, password) },
            enabled = authState.value != AuthState.Loading
        ) {
            Text(
                color = GrayScale0,
                text = "Sign In",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold))
            )
        }

        Column(
            modifier = Modifier
                .padding(top = 24.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(modifier = Modifier
                    .padding(bottom = 4.dp)
                    .align(Alignment.CenterHorizontally),
                text = "By registering you agree to",
                color = GrayScale0,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_medium))
            )

            Row(modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
            ){
                val termsConditions = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = azul300,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)))) {
                        pushStringAnnotation(tag = "signup", annotation = "Navigate to Detail Screen")
                        append("Termos e condicoes")
                        pop()
                    }
                }
                ClickableText(
                    text = termsConditions,
                    onClick = { offset ->
                        termsConditions.getStringAnnotations(tag = "signup", start = offset, end = offset)
                            .firstOrNull()
                            ?.let {
                                navController.navigate("signup")
                            }
                    }
                )



                Text(
                    modifier = Modifier
                        .padding(start = 5.dp,end = 5.dp)
                        .align(Alignment.CenterVertically),
                    text = "and",
                    color = GrayScale0,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_medium))
                )

                val privacyPolicy = buildAnnotatedString {
                    withStyle(style = SpanStyle(
                        color = azul300,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)))
                    ) {
                        pushStringAnnotation(tag = "Politica de privacidade", annotation = "Navigate to Detail Screen")
                        append("Politica de privacidade")
                        pop()
                    }
                }
                ClickableText(
                    text = privacyPolicy,
                    onClick = { offset ->
                        privacyPolicy.getStringAnnotations(tag = "Politica de privacidade", start = offset, end = offset)
                            .firstOrNull()
                            ?.let {
                                navController.navigate("signup")
                            }
                    }
                )
            }

            Row(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally),
                horizontalArrangement = Arrangement.Center
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
                        pushStringAnnotation(tag = "login", annotation = "Navigate to Detail Screen")
                        append("Login")
                        pop()
                    }
                }
                ClickableText(
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

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isFocused: Boolean,
    onFocusChange: (Boolean) -> Unit,
    placeholder: String,
    azulOpacity: Color,
    grayScale: Color
) {
    Column {
        Text(text = label)
        Spacer(modifier = Modifier.padding(top = 10.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .onFocusChanged { focusState -> onFocusChange(focusState.isFocused) }
                .background(if (isFocused) azulOpacity else grayScale),
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart)
                ){
                    Text(
                        text = placeholder,
                        style = TextStyle(fontSize = 16.sp, color = GrayScale400),
                    )}
                },
            shape = RoundedCornerShape(16.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = azul300,
                unfocusedBorderColor = GrayScale700
            )
        )
    }
}

