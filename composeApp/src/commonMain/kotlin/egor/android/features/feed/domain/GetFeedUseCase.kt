package egor.android.features.feed.domain

import egor.android.features.favorite.data.FavoriteLocalDataSource
import egor.android.features.favorite.data.FavoriteRoomDataSource
import egor.android.features.feed.data.FeedKtorDataSource
import egor.android.features.feed.data.FeedRemoteDataSource
import egor.android.features.feed.domain.models.Feed
import egor.android.features.feed.domain.models.mapToFeed
import egor.android.features.login.data.AuthEncryptedDataSource
import egor.android.features.login.data.AuthLocalDataSource

class GetFeedUseCase(
    private val authLocalDataSource: AuthLocalDataSource = AuthEncryptedDataSource(),
    private val feedRemoteDataSource: FeedRemoteDataSource = FeedKtorDataSource(),
    private val favoriteLocalDataSource: FavoriteLocalDataSource = FavoriteRoomDataSource()
) {

    suspend fun execute(): List<Feed> {
        val token = authLocalDataSource.checkToken()
        val favorites = favoriteLocalDataSource.getFavoritePosts()
        val feed =
            feedRemoteDataSource.fetchNextChunk(token = token, postId = "", filters = emptyList())
                .map { it.mapToFeed(isFavorite = favorites.contains(it.postId)) }
        return feed
    }
}