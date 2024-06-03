package egor.android.features.login

import egor.android.base.BaseViewModel
import egor.android.features.login.models.LoginAction
import egor.android.features.login.models.LoginEvent
import egor.android.features.login.models.LoginViewState

class LoginViewModel :
    BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> viewState =
                viewState.copy(emailValue = viewEvent.newValue)

            is LoginEvent.PasswordChanged -> viewState =
                viewState.copy(passwordValue = viewEvent.newValue)
        }
    }
}