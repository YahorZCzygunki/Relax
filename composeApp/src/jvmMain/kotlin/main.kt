import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import java.awt.Dimension
import egor.android.App
import egor.android.core.database.getDatabaseBuilder
import egor.android.core.database.getRoomDatabase
import egor.android.core.di.InjectProvider

fun main() = application {
    Window(
        title = "Relax",
        state = rememberWindowState(width = 800.dp, height = 600.dp),
        onCloseRequest = ::exitApplication,
    ) {
        window.minimumSize = Dimension(350, 600)

        val appDatabase = getRoomDatabase(getDatabaseBuilder())

        InjectProvider.addDependency("database", appDatabase)

        App()
    }
}