package egor.android.features.profile.ui.views

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import egor.android.theme.RelaxTheme

@Composable
fun ProfileAboutView() {
    Text(text = "About", color = RelaxTheme.colors.primaryText)
}