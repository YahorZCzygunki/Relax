package egor.android.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val darkPalette = RelaxColors(
    primaryBackground = Color(0xFF141217),
    primaryText = Color(0xFFFFFFFF),
    secondaryBackground = Color(0xFF302938),
    secondaryText = Color(0xFFFFFFFF),
    tintColor = Color(0xFFAB9EB8),
    dividerColor = Color(0xFF473D54)
)

val LocalRelaxColor =
    staticCompositionLocalOf<RelaxColors> { error("No default implementation for colors") }
