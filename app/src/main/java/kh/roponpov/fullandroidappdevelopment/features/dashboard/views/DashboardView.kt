package kh.roponpov.fullandroidappdevelopment.features.dashboard.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.features.dashboard.components.FeatureCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(
    onNavigateDetail: (route: String) -> Unit,
) {
    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(0, 0, 0, 0),
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(
                            alignment = Alignment.CenterHorizontally,
                            space = 10.dp,
                        ),
                    ) {
                        Icon(
                            modifier = Modifier.size(35.dp),
                            painter = painterResource(R.drawable.ic_android_icon),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Android Icon",
                        )
                        Text(
                            text = stringResource(R.string.android_jetpack_compose),
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 16.dp, vertical = 12.dp),
        ) {
            FeatureCard(
                title = stringResource(R.string.runtime_permissions),
                description = stringResource(R.string.runtime_permissions_description),
                iconRes = R.drawable.ic_sync,
                onClick = { onNavigateDetail("runtime_permission") },
            )

            Spacer(modifier = Modifier.height(16.dp))

            FeatureCard(
                title = stringResource(R.string.aba_dashboard),
                description = stringResource(R.string.aba_dashboard_description),
                iconRes = R.drawable.ic_account_banking,
                onClick = { onNavigateDetail("mobile_banking") },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    MaterialTheme {
        DashboardView(
            onNavigateDetail = {},
        )
    }
}