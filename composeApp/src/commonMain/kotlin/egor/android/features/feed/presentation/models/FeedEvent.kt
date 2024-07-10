package egor.android.features.feed.presentation.models

sealed class FeedEvent {

    class ClickItemFilter(val filterId: String) : FeedEvent()

    class PostClicked(val postId: String) : FeedEvent()

    data object UserClicked : FeedEvent()

    data object LoadMore : FeedEvent()
}