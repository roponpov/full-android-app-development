package kh.roponpov.fullandroidappdevelopment.features.login.views.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.features.login.views.LoginView

@Composable
fun WelcomeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 32.dp,
                end = 32.dp,
                top = 32.dp,
                bottom = 16.dp
            )
    ) {
        Text(
            "Welcome Back",
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Bold,
            )
        )

        Text(
            "Please enter your details to continue your\n" + "journey.",
            style = MaterialTheme.typography.labelLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Normal,
            )
        )
    }
}

@Composable
@Preview
fun PreviewLoginView(){
    LoginView(rememberNavController())
}