package egor.android.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

data class RelaxColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val dividerColor: Color
)

object RelaxTheme {
    val colors: RelaxColors
        @Composable
        get() = LocalRelaxColor.current
}