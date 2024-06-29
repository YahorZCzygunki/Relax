package egor.android.common.tiextfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import egor.android.theme.AppTheme
import egor.android.theme.RelaxTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RTextField(
    text: String,
    hint: String = "",
    enabled: Boolean = true,
    onTextChanged: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 12.dp)
            .fillMaxWidth()
            .height(56.dp),
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        placeholder = {
            Text(
                text = hint,
                color = RelaxTheme.colors.tintColor,
                fontSize = 14.sp
            )
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = RelaxTheme.colors.secondaryBackground,
            focusedContainerColor = RelaxTheme.colors.secondaryBackground,
            disabledContainerColor = RelaxTheme.colors.secondaryBackground.copy(alpha = 0.3F),
            focusedTextColor = RelaxTheme.colors.tintColor,
            unfocusedTextColor = RelaxTheme.colors.tintColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        textStyle = TextStyle(fontSize = 14.sp),
        value = text,
        onValueChange = onTextChanged,
    )
}

@Composable
@Preview
fun RTextField_Preview() {
    AppTheme {
        RTextField(text = "Some text", hint = "email") {

        }
    }
}

@Composable
@Preview
fun RTextField_Disabled_Preview() {
    AppTheme {
        RTextField(
            text = "Some text",
            enabled = false
        ) {

        }
    }
}