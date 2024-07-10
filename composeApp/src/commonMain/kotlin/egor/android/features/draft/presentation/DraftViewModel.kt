package egor.android.features.draft.presentation

import egor.android.core.di.InjectProvider
import egor.android.features.draft.domain.SaveDraftUseCase

class DraftViewModel(

) {

    private val saveDraftUseCase =
        SaveDraftUseCase(draftDao = InjectProvider.getDatabase().getDraftDao())
}