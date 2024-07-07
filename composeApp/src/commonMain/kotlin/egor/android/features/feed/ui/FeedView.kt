package egor.android.features.feed.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import egor.android.features.feed.presentation.models.FeedEvent
import egor.android.features.feed.presentation.models.FeedState
import egor.android.features.feed.ui.views.ItemFeedCell
import egor.android.features.feed.ui.views.ItemFilterCell
import egor.android.theme.RelaxTheme

@Composable
fun FeedView(viewState: FeedState, onEvent: (FeedEvent) -> Unit) {

    Column {

        Box(modifier = Modifier.fillMaxWidth().height(72.dp).padding(horizontal = 16.dp)) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(RelaxTheme.colors.secondaryBackground)
                    .align(Alignment.CenterStart)
            )

            Text(
                modifier = Modifier.align(Alignment.Center),
                text = viewState.title,
                color = RelaxTheme.colors.primaryText
            )
        }

        LazyRow(modifier = Modifier.height(56.dp).padding(6.dp)) {

            items(viewState.filters) {

                ItemFilterCell(it) {
                    onEvent(FeedEvent.CLickItemFilter(it.text))
                }
            }
        }

        LazyColumn(modifier = Modifier) {

            items(viewState.itemFeedModels) {

                ItemFeedCell(it)
            }
        }

    }
}