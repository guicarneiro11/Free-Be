package com.guicarneirodev.freebe.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFF810E1B),          // Vermelho principal
            primaryContainer = Color(0xFF5C0A13),  // Vermelho mais escuro para gradiente
            secondary = Color(0xFFD32F2F),         // Vermelho mais claro para acentos
            tertiary = Color(0xFF9A1111),          // Vermelho alternativo
            background = Color(0xFFFFFFFF),       // Fundo claro
            surface = Color.White,                 // Superfície dos cards
            onPrimary = Color.White,              // Texto sobre primary
            onSecondary = Color.White,            // Texto sobre secondary
            onBackground = Color.White,            // Texto sobre background
            onSurface = Color(0xFF810E1B)         // Texto/ícones sobre surface (cards)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF810E1B),          // Vermelho principal
            primaryContainer = Color(0xFF5C0A13),  // Vermelho mais escuro para gradiente
            secondary = Color(0xFFD32F2F),         // Vermelho mais claro para acentos
            tertiary = Color(0xFF9A1111),          // Vermelho alternativo
            background = Color.White,              // Fundo claro
            surface = Color.White,                 // Superfície dos cards
            onPrimary = Color.White,              // Texto sobre primary
            onSecondary = Color.White,            // Texto sobre secondary
            onBackground = Color(0xFF810E1B),      // Texto sobre background
            onSurface = Color(0xFF810E1B)         // Texto/ícones sobre surface (cards)
        )
    }

    val typography = Typography(
        // Títulos
        headlineLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp
        ),
        // Subtítulos
        bodyLarge = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp
        ),
        // Texto dos cards
        titleMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp
        ),
        bodySmall = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        )
    )

    val shapes = Shapes(
        // Mais arredondado para os cards
        small = RoundedCornerShape(12.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(20.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}