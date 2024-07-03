package egor.android.features.profile.ui.views

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import egor.android.theme.AppTheme
import egor.android.theme.RelaxTheme

@Composable
fun ProfileTabView(
    items: List<String>,
    selectedIndex: Int,
    onItemSelected: (Int) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth().height(54.dp)) {
        Row(modifier = Modifier.fillMaxHeight()) {
            items.forEach {
                val index = items.indexOf(it)

                Spacer(modifier = Modifier.size(16.dp))
                ProfileTab(
                    title = it,
                    isSelected = selectedIndex == index
                ) {
                    onItemSelected(index)
                }
                Spacer(modifier = Modifier.size(16.dp))
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth().height(1.dp),
            color = RelaxTheme.colors.dividerColor
        )
    }
}

@Composable
internal fun ProfileTab(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Box(modifier = Modifier.clickable { onClick() }.width(IntrinsicSize.Min).fillMaxHeight()) {
        Text(
            modifier = Modifier.width(IntrinsicSize.Max).align(Alignment.Center),
            text = title,
            color = if (isSelected) RelaxTheme.colors.primaryText else RelaxTheme.colors.tintColor
        )

        Divider(
            modifier = Modifier.height(3.dp).align(Alignment.BottomStart),
            color = if (isSelected) RelaxTheme.colors.primaryText else RelaxTheme.colors.tintColor
        )
    }
}

@Composable
internal fun ProfileTabView_Preview() {
    AppTheme {
        ProfileTabView(
            items = listOf("Videos", "Playlist", "About"),
            onItemSelected = {},
            selectedIndex = 1
        )
    }
}