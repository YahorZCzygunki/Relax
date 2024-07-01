package egor.android.features.profile.presentation

import egor.android.base.BaseViewModel
import egor.android.features.profile.presentation.models.ProfileAction
import egor.android.features.profile.presentation.models.ProfileEvent
import egor.android.features.profile.presentation.models.ProfileViewState

class ProfileViewModel :
    BaseViewModel<ProfileViewState, ProfileAction, ProfileEvent>(initialState = ProfileViewState(
        name = "Egor",
        subscribers = "1.1m",
        joinedIn = "In 2020"
    )) {
    override fun obtainEvent(viewEvent: ProfileEvent) {
        when (viewEvent) {
            is ProfileEvent.TabSelected -> viewState =
                viewState.copy(selectedTabIndex = viewEvent.index)
        }
    }
}