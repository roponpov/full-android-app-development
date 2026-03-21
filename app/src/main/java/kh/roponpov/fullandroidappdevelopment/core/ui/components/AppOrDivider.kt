package kh.roponpov.fullandroidappdevelopment.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.features.login.views.LoginView

@Composable
fun AppOrDivider(
    text: String,
    paddingValues: PaddingValues
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(paddingValues),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary.copy(
                        alpha = 0.2f
                    )
                )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text,
            style = MaterialTheme.typography.labelLarge.copy(
                color = MaterialTheme.colorScheme.onPrimary.copy(
                    alpha = 0.5f
                )
            )
        )
        Spacer(modifier = Modifier.width(10.dp))
        Box(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = MaterialTheme.colorScheme.onPrimary.copy(
                        alpha = 0.2f
                    )
                )
        )
    }
}