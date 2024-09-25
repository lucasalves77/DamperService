package androidx.compose.material3.samples

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Medium
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.damper.AuthViewModel
import com.lucas.damper.R
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale400
import com.lucas.damper.ui.theme.GrayScale700
import com.lucas.damper.ui.theme.GrayScale900
import com.lucas.damper.ui.theme.alert100
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalLogout(navController: NavController, authViewModel: AuthViewModel) {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by rememberSaveable { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState =
        rememberModalBottomSheetState(skipPartiallyExpanded = skipPartiallyExpanded)

    // App content
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        TextButton(modifier = Modifier
            .width(100.dp)
            .align(Alignment.CenterHorizontally),
            onClick = { openBottomSheet = !openBottomSheet }
        ) {
            Text(
                fontWeight = FontWeight.Medium,
                fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                color = alert100,
                text = "Sair",
                fontSize = 24.sp,
            )
        }
    }

    // Sheet content
    if (openBottomSheet) {
        Box(modifier = Modifier.fillMaxSize()) {

            ModalBottomSheet(
                onDismissRequest = { openBottomSheet = false },
                sheetState = bottomSheetState,
                containerColor = GrayScale900,
                scrimColor = Color.Black.copy(alpha = 0.90f)
            ) {

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 80.dp)
                ) {
                    Text(
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally),
                        fontSize = 24.sp,
                        fontWeight = Bold,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                        color = alert100,
                        text = "Logout"
                    )

                    Divider(modifier = Modifier
                        .padding(top = 24.dp)
                        .fillMaxWidth(),
                        color = GrayScale700,
                        thickness = 1.dp,
                    )

                    Text(modifier = Modifier
                        .padding(top = 30.dp, bottom = 30.dp)
                        .align(Alignment.CenterHorizontally),
                        fontSize = 16.sp,
                        fontWeight = Medium,
                        fontFamily = FontFamily(Font(R.font.plusjakartasans_medium)),
                        color = GrayScale400,
                        maxLines = 2,
                        textAlign = TextAlign.Center,
                        text = "You are about to logout in 3 secs,\n Do you want to continue?"
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth(),
                    ) {
                        Button(
                            modifier = Modifier
                                .weight(1f)
                                .height(60.dp)
                                .border(BorderStroke(1.dp, alert100), RoundedCornerShape(16.dp)),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                            onClick = { scope.launch { bottomSheetState.hide() }
                                .invokeOnCompletion {
                                    if (!bottomSheetState.isVisible) {
                                        openBottomSheet = false
                                    }
                                } }
                        ) {
                            Text(
                                fontSize = 18.sp,
                                fontWeight = Bold,
                                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                                color = alert100,
                                text = "Cancelar"
                            )
                        }
                        Spacer(modifier = Modifier.padding(start = 20.dp))
                        Button(
                            modifier = Modifier
                                .height(60.dp)
                                .weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = alert100),
                            onClick = {  authViewModel.signout()
                                navController.navigate("login") {
                                    popUpTo("home") { inclusive = true }
                                }
                            }
                        ) {
                            Text(
                                color = GrayScale0,
                                fontSize = 18.sp,
                                fontWeight = Bold,
                                fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
                                text = "Sair"
                            )
                        }
                    }
                }
            }
        }
    }
}
