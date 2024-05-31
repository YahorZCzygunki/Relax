import androidx.compose.ui.window.ComposeUIViewController
import egor.android.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController { App() }
