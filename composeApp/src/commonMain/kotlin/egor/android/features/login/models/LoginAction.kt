package egor.android.features.login.models

sealed class LoginAction {

    data object OpenMainScreen : LoginAction()
}