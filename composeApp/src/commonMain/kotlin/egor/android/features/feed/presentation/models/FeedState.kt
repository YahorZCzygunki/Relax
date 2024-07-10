package egor.android.features.feed.presentation.models

import egor.android.features.feed.ui.views.models.ItemFeedModel
import egor.android.features.feed.ui.views.models.ItemFilterModel

data class FeedState(
    val avatar: String = "",
    val title: String = "",
    val filters: List<ItemFilterModel> = emptyList(),
    val itemFeedModels: List<ItemFeedModel> = listOf(
        ItemFeedModel(title = "1", category = "11", socialInfo = "111"),
        ItemFeedModel(title = "2", category = "22", socialInfo = "222"),
        ItemFeedModel(title = "3", category = "33", socialInfo = "333")
    ),
    val filteredFeedModels: List<ItemFeedModel> = listOf(
        ItemFeedModel(title = "1", category = "11", socialInfo = "111"),
        ItemFeedModel(title = "2", category = "22", socialInfo = "222"),
        ItemFeedModel(title = "3", category = "33", socialInfo = "333")
    ),
    val currentChipSelected: String? = null
)