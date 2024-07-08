package egor.android.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import egor.android.features.draft.data.DraftDao
import egor.android.features.draft.data.DraftEntity

@Database(entities = [DraftEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDraftDao(): DraftDao
}

internal const val dbFileName = "apprelax.dp"