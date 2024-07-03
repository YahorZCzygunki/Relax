package egor.android.features.splash

import egor.android.base.BaseViewModel
import egor.android.features.login.domain.IsUSerAuthorizedUseCase
import egor.android.features.splash.models.SplashAction

class SplashViewModel(
    private val isUSerAuthorized: IsUSerAuthorizedUseCase = IsUSerAuthorizedUseCase()
) : BaseViewModel<Unit, SplashAction, Unit>(
    initialState = Unit
) {

    init {
        checkUserAuthorized()
    }

    override fun obtainEvent(viewEvent: Unit) {

    }

    private fun checkUserAuthorized() {
        viewAction = if (isUSerAuthorized.execute()) {
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }
}