package egor.android.features.feed.ui.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import egor.android.features.feed.ui.views.models.ItemFilterModel
import egor.android.theme.RelaxTheme

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemFilterCell(itemFilterModel: ItemFilterModel, onClick: () -> Unit) {

    Chip(
        modifier = Modifier.padding(horizontal = 6.dp),
        onClick = onClick,
        colors = ChipDefaults.chipColors(
            backgroundColor = if (itemFilterModel.isSelected) {
                RelaxTheme.colors.tintColor
            } else {
                RelaxTheme.colors.secondaryBackground
            }

        )
    ) {
        Text(
            text = itemFilterModel.text,
            color = RelaxTheme.colors.primaryText,
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
        )
    }
}