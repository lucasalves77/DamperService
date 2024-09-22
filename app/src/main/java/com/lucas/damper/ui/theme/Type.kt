package com.lucas.damper.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.lucas.damper.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.plusjakartasans_bold)),
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
    ),

    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.plusjakartasans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        color = GrayScale400,
    ),
    /* Other default text styles to override
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)