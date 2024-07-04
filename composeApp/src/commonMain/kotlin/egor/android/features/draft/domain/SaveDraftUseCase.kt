package egor.android.features.draft.domain

import egor.android.core.di.InjectProvider
import egor.android.features.draft.data.DraftDao
import egor.android.features.draft.data.DraftEntity
import kotlinx.uuid.UUID

class SaveDraftUseCase(
    private val draftDao: DraftDao = InjectProvider.getDatabase().getDraftDao()
) {

    suspend fun execute(title: String, text: String) {
        draftDao.insert(
            DraftEntity(
                draftId = UUID().toString(false),
                title = title,
                text = text
            )
        )
    }
}