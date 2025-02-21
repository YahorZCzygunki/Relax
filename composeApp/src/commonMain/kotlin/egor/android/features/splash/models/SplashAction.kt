package egor.android.features.splash.models

sealed class SplashAction {
    data object ShowMainScreen : SplashAction()
    data object ShowLoginScreen : SplashAction()
}