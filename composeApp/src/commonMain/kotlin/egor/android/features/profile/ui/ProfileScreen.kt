package egor.android.features.profile.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import egor.android.features.profile.presentation.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel { ProfileViewModel() }
) {
    val viewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)
    ProfileView(
        viewState = viewState
    ) {
        viewModel.obtainEvent(it)
    }
}