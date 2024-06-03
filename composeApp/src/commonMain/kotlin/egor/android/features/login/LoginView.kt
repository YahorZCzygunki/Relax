package egor.android.features.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import egor.android.common.tiextfield.RTextField
import egor.android.features.login.models.LoginEvent
import egor.android.features.login.models.LoginViewState
import egor.android.theme.AppTheme
import egor.android.theme.RelaxTheme
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import relax.composeapp.generated.resources.Res
import relax.composeapp.generated.resources.login_email
import relax.composeapp.generated.resources.login_forgot
import relax.composeapp.generated.resources.login_intro
import relax.composeapp.generated.resources.login_login
import relax.composeapp.generated.resources.login_password
import relax.composeapp.generated.resources.login_register
import relax.composeapp.generated.resources.login_signup
import relax.composeapp.generated.resources.login_title
import relax.composeapp.generated.resources.login_welcome_back

@Composable
internal fun LoginView(
    viewState: LoginViewState,
    eventHandler: (LoginEvent) -> Unit
) {
    Column {
        Box(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
                .height(48.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_title),
                color = RelaxTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp)
                .fillMaxWidth()
                .height(28.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_welcome_back),
                color = RelaxTheme.colors.primaryText,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        }
        Box(
            modifier = Modifier
                .padding(top = 20.dp, bottom = 12.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = stringResource(Res.string.login_intro),
                color = RelaxTheme.colors.primaryText,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
        RTextField(
            text = viewState.emailValue,
            hint = stringResource(Res.string.login_email),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.EmailChanged(it))
        }

        RTextField(
            text = viewState.passwordValue,
            hint = stringResource(Res.string.login_password),
            enabled = !viewState.isSending
        ) {
            eventHandler.invoke(LoginEvent.PasswordChanged(it))
        }
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier.size(width = 156.dp, height = 40.dp).clickable { }) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = stringResource(Res.string.login_forgot),
                    color = RelaxTheme.colors.primaryText
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier.size(width = 84.dp, height = 40.dp).clickable { }) {
                Text(
                    modifier = Modifier.align(Alignment.Center),
                    text = stringResource(Res.string.login_login),
                    color = RelaxTheme.colors.primaryText
                )
            }
        }
        Row {
            Text(
                modifier = Modifier.padding(top = 4.dp, bottom = 12.dp, start = 16.dp),
                text = stringResource(Res.string.login_register),
                color = RelaxTheme.colors.tintColor
            )
            Text(
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 12.dp, end = 16.dp)
                    .clickable {

                    },
                text = stringResource(Res.string.login_signup),
                color = RelaxTheme.colors.tintColor
            )
        }
    }
}

@Composable
@Preview
fun LoginView_Preview() {
    AppTheme {
        LoginView(
            viewState = LoginViewState(
                emailValue = "111@ffs.vv",
                passwordValue = "q22222"
            ),
            eventHandler = {}
        )
    }
}