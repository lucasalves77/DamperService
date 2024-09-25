package com.lucas.damper

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lucas.damper.ui.theme.GrayScale0
import com.lucas.damper.ui.theme.GrayScale800
import com.lucas.damper.ui.theme.azul200

@Composable
fun TopBar(navController: NavController) {
    Row(
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
                .background(GrayScale800),
            onClick = { navController.navigate("home") }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.arrowicon),
                contentDescription = null,
                tint = GrayScale0
            )
        }

        Text(
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
            fontSize = 18.sp,
            color = GrayScale0,
            text = "Search"
        )

        Icon(
            painter = painterResource(id = R.drawable.dotsicon),
            contentDescription = null,
            tint = GrayScale0
        )
    }
}
