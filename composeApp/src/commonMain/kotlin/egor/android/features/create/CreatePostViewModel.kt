package egor.android.features.create

import egor.android.base.BaseViewModel
import egor.android.features.create.models.CreatePostAction
import egor.android.features.create.models.CreatePostEvent
import egor.android.features.create.models.CreatePostViewState

class CreatePostViewModel :
    BaseViewModel<CreatePostViewState, CreatePostAction, CreatePostEvent>(initialState = CreatePostViewState()) {

    override fun obtainEvent(viewEvent: CreatePostEvent) {

    }
}