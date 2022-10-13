package com.beatrice.moviesapp.presentation.view.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun ErrorMessageComponent(
    message: String = "Something went wrong",
) {
    Text(
        text = message,
        modifier = Modifier.fillMaxSize(),
        style = TextStyle(
            fontFamily = FontFamily.Serif,
            color = Color.LightGray,
            fontSize = 24.sp
        ),
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
fun ErrorMessageComponentPreview() {
    Surface(color = Color.White) {
        ErrorMessageComponent()
    }
}