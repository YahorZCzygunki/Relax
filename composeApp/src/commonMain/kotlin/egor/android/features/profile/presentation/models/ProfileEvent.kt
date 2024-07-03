package egor.android.features.profile.presentation.models

sealed class ProfileEvent {
    class TabSelected(val index: Int) : ProfileEvent()
}