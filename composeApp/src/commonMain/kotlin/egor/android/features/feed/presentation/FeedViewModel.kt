package egor.android.features.feed.presentation

import egor.android.base.BaseViewModel
import egor.android.features.feed.presentation.models.FeedAction
import egor.android.features.feed.presentation.models.FeedEvent
import egor.android.features.feed.presentation.models.FeedState
import egor.android.features.feed.ui.views.models.ItemFilterModel

class FeedViewModel :
    BaseViewModel<FeedState, FeedAction, FeedEvent>(initialState = FeedState()) {

    init {
        loadScreen()
    }

    private fun loadScreen() {

        viewState = viewState.copy(filters = generateFilters())
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when (viewEvent) {
            is FeedEvent.CLickItemFilter -> handleCLickItemFilter(viewEvent.type)
        }
    }

    private fun handleCLickItemFilter(type: String) {
        viewState = viewState.copy(currentChipSelected = type)
        loadScreen()
    }

    private fun generateFilters() = listOf(
        ItemFilterModel(text = "1", isSelected = "1" == viewState.currentChipSelected),
        ItemFilterModel(text = "2", isSelected = "2" == viewState.currentChipSelected),
        ItemFilterModel(text = "3", isSelected = "3" == viewState.currentChipSelected)
    )
}