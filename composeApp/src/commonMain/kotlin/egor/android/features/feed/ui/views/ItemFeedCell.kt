package egor.android.features.feed.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import egor.android.features.feed.ui.views.models.ItemFeedModel
import egor.android.theme.RelaxTheme

@Composable
fun ItemFeedCell(feedModel: ItemFeedModel) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(RelaxTheme.colors.secondaryBackground)
            .aspectRatio(16f / 9f))

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = feedModel.title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = RelaxTheme.colors.primaryText
        )

        Spacer(modifier = Modifier.size(8.dp))

        Text(
            text = feedModel.category,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = RelaxTheme.colors.tintColor
        )

        Text(
            text = feedModel.socialInfo,
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            color = RelaxTheme.colors.tintColor
        )
    }
}