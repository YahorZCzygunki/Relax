package egor.android.features.feed.data

import egor.android.features.feed.data.models.KtorFeedModel

interface FeedRemoteDataSource {

    suspend fun fetchNextChunk(token: String, postId: String, filters: List<String>): List<KtorFeedModel>
}