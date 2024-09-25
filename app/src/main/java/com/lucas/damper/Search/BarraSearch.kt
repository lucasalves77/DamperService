import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.lucas.damper.R
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale500
import com.lucas.damper.ui.theme.GrayScale300
import com.lucas.damper.ui.theme.GrayScale800
import com.lucas.damper.ui.theme.GrayScale900
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarraSearch() {
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current
    var isFocusedSearch by remember { mutableStateOf(false) }
    var openBottomSheet by remember { mutableStateOf(false) } // Controla a exibição do modal
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true) // Sem initialValue
    val scope = rememberCoroutineScope()

    val azulOpacity = Color(0xFF0099FF).copy(alpha = 0.2f)

    Box(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus() // Remove o foco ao clicar fora
                })
            }
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp)
                .height(70.dp)
                .clip(RoundedCornerShape(30.dp))
                .onFocusChanged { focusState ->
                    isFocusedSearch = focusState.isFocused
                }
                .background(
                    if (isFocusedSearch) azulOpacity else GrayScale800
                ),
            value = text,
            onValueChange = { newText -> text = newText },
            placeholder = {
                Text(
                    color = GrayScale400,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                    text = "Buscar serviços"
                )
            },
            shape = RoundedCornerShape(30.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xFF0099FF),
                unfocusedBorderColor = Color.Transparent,
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = { focusManager.clearFocus() }
            ),
            leadingIcon = {
                Icon(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 10.dp),
                    painter = painterResource(id = R.drawable.searchicon),
                    contentDescription = null,
                    tint = GrayScale300
                )
            },
            trailingIcon = {
                Box(
                    modifier = Modifier
                        .height(24.dp)
                        .width(60.dp)
                        .background(Color.Transparent)
                ) {
                    Row(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Box(
                            modifier = Modifier
                                .width(1.dp)
                                .fillMaxHeight()
                                .background(Color.Gray)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        IconButton(onClick = {
                            scope.launch {
                                bottomSheetState.show() // Abre o modal
                                openBottomSheet = true
                            }
                        }) {
                            Icon(
                                painter = painterResource(id = R.drawable.filtroicon),
                                contentDescription = null,
                                tint = GrayScale500
                            )
                        }
                    }
                }
            }
        )

        // ModalBottomSheet é exibido aqui
        if (openBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = {
                    scope.launch {
                        bottomSheetState.hide()
                        openBottomSheet = false
                    }
                },
                sheetState = bottomSheetState,
                containerColor = GrayScale900,
                scrimColor = Color.Black.copy(alpha = 0.7f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Filtro",
                        style = MaterialTheme.typography.headlineMedium
                    )

                    Button(onClick = {
                        scope.launch {
                            bottomSheetState.hide()
                            openBottomSheet = false
                        }
                    }) {
                        Text(text = "Fechar")
                    }
                }
            }
        }
    }
}
