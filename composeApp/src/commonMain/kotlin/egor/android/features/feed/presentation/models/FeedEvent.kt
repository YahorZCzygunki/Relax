package egor.android.features.feed.presentation.models

sealed class FeedEvent {

    class CLickItemFilter(val type: String) : FeedEvent()
}