package egor.android.features.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import egor.android.features.login.models.LoginAction
import egor.android.navigations.AppScreens
import egor.android.navigations.LocalNavHost

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = viewModel { LoginViewModel() }
) {
    val externalNavHost = LocalNavHost.current
    val viewState by loginViewModel.viewStates().collectAsState()
    val viewAction by loginViewModel.viewActions().collectAsState(null)

    LoginView(viewState = viewState) { event ->
        loginViewModel.obtainEvent(event)
    }

    when (viewAction) {
        LoginAction.OpenMainScreen -> {
            externalNavHost.navigate(AppScreens.Main.title)
            loginViewModel.clearAction()
        }

        null -> {}
    }
}