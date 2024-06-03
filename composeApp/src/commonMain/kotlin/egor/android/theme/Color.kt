package egor.android.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val darkPalette = RelaxColors(
    primaryBackground = Color(0xFF141217),
    primaryText = Color.White,
    secondaryBackground = Color(0xFF302938),
    secondaryText = Color.White,
    tintColor = Color(0xFFAB9EB8),
    dividerColor = Color(0xFF473D54)
)

val LocalRelaxColor =
    staticCompositionLocalOf<RelaxColors> { error("No default implementation for colors") }
