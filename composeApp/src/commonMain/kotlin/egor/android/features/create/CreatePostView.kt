package egor.android.features.create

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import egor.android.features.create.models.CreatePostEvent
import egor.android.features.create.models.CreatePostViewState
import egor.android.theme.AppTheme
import egor.android.theme.RelaxTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CreatePostView(
    viewState: CreatePostViewState,
    eventHandler: (CreatePostEvent) -> Unit
) {
    Box(modifier = Modifier.fillMaxWidth().height(72.dp)) {
        Text("Title", color = RelaxTheme.colors.primaryText,
            fontSize = 16.sp)
    }
}

@Composable
@Preview
fun CreatePostView_Preview() {
    AppTheme {
        CreatePostView(
            viewState = CreatePostViewState()
        ) {

        }
    }
}