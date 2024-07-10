package egor.android.features.feed.data

import egor.android.core.network.DemoHttpClient
import egor.android.core.network.HttpClient
import egor.android.features.feed.data.models.KtorFeedModel

class FeedKtorDataSource(
    private val httpClient: HttpClient = DemoHttpClient()
) : FeedRemoteDataSource {

    override suspend fun fetchNextChunk(
        token: String,
        postId: String,
        filters: List<String>
    ): List<KtorFeedModel> {
        return emptyList()
    }
}