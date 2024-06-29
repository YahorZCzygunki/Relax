package egor.android

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import egor.android.features.create.CreatePostScreen
import egor.android.features.login.LoginScreen
import egor.android.features.paywall.PaywallScreen
import egor.android.navigations.AppScreens
import egor.android.navigations.LocalNavHost
import egor.android.navigations.main.MainScreen
import egor.android.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    RelaxApp()
}

@Composable
internal fun RelaxApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = backStackEntry?.destination?.route ?: AppScreens.Login

    CompositionLocalProvider(
        LocalNavHost provides navController
    ) {
        NavHost(
            navController = navController,
            startDestination = AppScreens.Login.title
        ) {
            composable(route = AppScreens.Login.title) {
                LoginScreen()
            }
            composable(route = AppScreens.Main.title) {
                MainScreen()
            }
            composable(route = AppScreens.CreatePost.title) {
                CreatePostScreen()
            }
            composable(route = AppScreens.Paywall.title) {
                PaywallScreen()
            }
        }
    }
}

internal expect fun openUrl(url: String?)