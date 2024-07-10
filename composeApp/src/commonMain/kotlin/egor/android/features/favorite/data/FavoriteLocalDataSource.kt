package egor.android.features.favorite.data

import egor.android.core.database.AppDatabase
import egor.android.core.di.InjectProvider

interface FavoriteLocalDataSource {
    suspend fun getFavoritePosts(): List<String>
}

class FavoriteRoomDataSource(private val database: AppDatabase = InjectProvider.getDatabase()) :
    FavoriteLocalDataSource {

    override suspend fun getFavoritePosts(): List<String> {

        return emptyList()
    }
}