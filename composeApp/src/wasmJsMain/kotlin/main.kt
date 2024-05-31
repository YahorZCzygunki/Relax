import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.CanvasBasedWindow
import egor.android.App

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    CanvasBasedWindow("Relax") {
        App()
    }
}
