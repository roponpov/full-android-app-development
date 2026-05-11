package kh.roponpov.fullandroidappdevelopment.features.dashboard.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.fullandroidappdevelopment.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(
    onNavigateDetail: () -> Unit,
) {
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
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
                            text = "Android Jetpack Compose",
                            style = MaterialTheme.typography.titleLarge.copy(
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold,
                            ),
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            OutlinedCard(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                border = BorderStroke(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.primary,
                ),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                ),
            ) {
                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                ){
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Box(
                            modifier = Modifier
                                .background(
                                    shape = RoundedCornerShape(16.dp),
                                    color = MaterialTheme.colorScheme.primary.copy(
                                        alpha = 0.2f,
                                    ),
                                )
                                .padding(16.dp),
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_sync),
                                tint = MaterialTheme.colorScheme.primary,
                                contentDescription = "Android Icon",
                            )
                        }
                        Icon(
                            painter = painterResource(R.drawable.ic_round_arrow_forward_ios),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Android Icon",
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Runtime Permissions",
                        style = MaterialTheme.typography.titleLarge.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Handle runtime permissions in Jetpack Compose to request and manage user access for features like camera, storage, and location. Ensure a smooth and secure user experience with proper permission handling.",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}
@Preview
@Composable
fun DashboardPreview() {
    DashboardView(onNavigateDetail = {})
}