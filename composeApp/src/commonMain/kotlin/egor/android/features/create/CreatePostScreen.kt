package egor.android.features.create

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import egor.android.features.create.models.CreatePostViewState

@Composable
fun CreatePostScreen(viewModel: CreatePostViewModel = viewModel { CreatePostViewModel() }) {

    val viewState: CreatePostViewState by viewModel.viewStates().collectAsState()
    val viewAction by viewModel.viewActions().collectAsState(null)

    CreatePostView(viewState) {

    }
}