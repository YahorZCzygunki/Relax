package egor.android.features.feed.presentation

import androidx.lifecycle.viewModelScope
import egor.android.base.BaseViewModel
import egor.android.features.feed.domain.GetFeedUseCase
import egor.android.features.feed.presentation.models.FeedAction
import egor.android.features.feed.presentation.models.FeedEvent
import egor.android.features.feed.presentation.models.FeedState
import egor.android.features.feed.ui.views.models.ItemFeedModel
import egor.android.features.feed.ui.views.models.ItemFilterModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FeedViewModel :
    BaseViewModel<FeedState, FeedAction, FeedEvent>(initialState = FeedState()) {

    private val getFeedUseCase = GetFeedUseCase()

    init {
        loadScreen()
    }

    override fun obtainEvent(viewEvent: FeedEvent) {
        when (viewEvent) {
            is FeedEvent.ClickItemFilter -> handleCLickItemFilter(viewEvent.filterId)
            is FeedEvent.PostClicked -> obtainPostClick(viewEvent.postId)
            FeedEvent.UserClicked -> showUserProfile()
            FeedEvent.LoadMore -> loadMoreFeed()
        }
    }

    private fun obtainPostClick(postId: String) {}

    private fun showUserProfile() {

    }

    private fun loadMoreFeed() {

    }

    private fun handleCLickItemFilter(type: String) {
        viewState = viewState.copy(currentChipSelected = type)
        loadScreen()
    }

    private fun loadScreen() {

        viewState = viewState.copy(filters = generateFilters())
        viewModelScope.launch(Dispatchers.Default) {
            val feed = getFeedUseCase.execute().map {
                ItemFeedModel(
                    postId = it.postId,
                    imageUrl = "",
                    title = it.title,
                    category = it.topics.joinToString(separator = ","),
                    socialInfo = "${it.likesCount} likes / ${it.repostCount} reposts",
                    hasBlur = it.postId == "1"
                )
            }

            withContext(Dispatchers.Main) {
                viewState = viewState.copy(
                    itemFeedModels = feed
                )
            }
        }
    }

    private fun generateFilters() = listOf(
        ItemFilterModel(text = "1", isSelected = "1" == viewState.currentChipSelected),
        ItemFilterModel(text = "2", isSelected = "2" == viewState.currentChipSelected),
        ItemFilterModel(text = "3", isSelected = "3" == viewState.currentChipSelected)
    )
}