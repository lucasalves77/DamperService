package com.lucas.damper.Profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.lucas.damper.R
import com.lucas.damper.ui.theme.GrayScale700
import com.lucas.damper.ui.theme.GrayScale800
import com.lucas.damper.ui.theme.azul300
import com.lucas.damper.ui.theme.azulOpacityInput

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun dadosPessoais(navController: NavHostController){
    Column {

        val azulOpacity = azulOpacityInput.copy(alpha = 0.2f)
        var email by remember { mutableStateOf("") }
        var isFocusedEmail by remember { mutableStateOf(false) }


        Row {
            Icon(painter = painterResource(id = R.drawable.arrowicon), contentDescription = null)
            Text(text = "Dados pessoais")
        }
        
        Image(painter = painterResource(id = R.drawable.fotoperfil), contentDescription = null)

        Column {
            Text(text = "Nome completo")

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                    .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Digite seu email") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )

            Text(text = "Nome completo")

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                    .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Digite seu email") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )

            Text(text = "Nome completo")

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                    .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Digite seu email") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )

            Text(text = "Nome completo")

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                    .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Digite seu email") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )

            Text(text = "Nome completo")

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(if (isFocusedEmail) azulOpacity else GrayScale800)
                    .onFocusChanged { focusState -> isFocusedEmail = focusState.isFocused },
                value = email,
                onValueChange = { email = it },
                placeholder = { Text(text = "Digite seu email") },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = azul300,
                    unfocusedBorderColor = GrayScale700
                )
            )
        }
    }
}