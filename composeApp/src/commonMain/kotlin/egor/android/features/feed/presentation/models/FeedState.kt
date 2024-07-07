package egor.android.features.feed.presentation.models

import egor.android.features.feed.ui.views.models.ItemFeedModel
import egor.android.features.feed.ui.views.models.ItemFilterModel

data class FeedState(
    val avatar: String = "",
    val title: String = "",
    val filters: List<ItemFilterModel> = emptyList(),
    val itemFeedModels: List<ItemFeedModel> = listOf(
        ItemFeedModel(title = "1", subtitle = "11", count = "111"),
        ItemFeedModel(title = "2", subtitle = "22", count = "222"),
        ItemFeedModel(title = "3", subtitle = "33", count = "333")
    ),
    val currentChipSelected: String? = null
)