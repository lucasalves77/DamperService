package com.lucas.damper

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle

@Composable
fun Hometext(navController: NavController) {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(color = Color.Blue, textDecoration = TextDecoration.LineThrough)) {
            pushStringAnnotation(tag = "detail", annotation = "Navigate to Detail Screen")
            append("Click here to go to Detail Screen")
            pop()
        }
    }

    ClickableText(
        text = text,
        onClick = { offset ->
            text.getStringAnnotations(tag = "detail", start = offset, end = offset)
                .firstOrNull()
                ?.let {
                    navController.navigate("detail")
                }
        },
        modifier = Modifier.padding(16.dp),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun DetailScreen() {
    Text(text = "This is the Detail Screen", modifier = Modifier.padding(16.dp))
}
