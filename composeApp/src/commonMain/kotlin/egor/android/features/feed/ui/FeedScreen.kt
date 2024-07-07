package egor.android.features.feed.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import egor.android.features.feed.presentation.FeedViewModel

@Composable
fun FeedScreen(viewModel: FeedViewModel = viewModel { FeedViewModel() }) {

    val viewsState by viewModel.viewStates().collectAsState()

    FeedView(viewState = viewsState) { event ->
        viewModel.obtainEvent(event)
    }
}