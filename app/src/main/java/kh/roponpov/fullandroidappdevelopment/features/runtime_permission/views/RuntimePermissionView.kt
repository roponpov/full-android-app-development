package kh.roponpov.fullandroidappdevelopment.features.runtime_permission.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.features.runtime_permission.models.RuntimePermissionModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RuntimePermissionsView() {
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
                            painter = painterResource(R.drawable.ic_security),
                            tint = MaterialTheme.colorScheme.primary,
                            contentDescription = "Android Icon",
                        )
                        Text(
                            text = stringResource(R.string.runtime_permissions),
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
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                val runtimePermissions = RuntimePermissionModel.runtimePermissions
                val permissionLength: Int = runtimePermissions.count()

                items(permissionLength) { index ->
                    val permission = runtimePermissions[index]

                    OutlinedCard {
                        Column(
                            modifier = Modifier
                                .padding(16.dp)
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Icon(
                                    modifier = Modifier.size(35.dp),
                                    painter = painterResource(permission.iconRes),
                                    tint = MaterialTheme.colorScheme.primary,
                                    contentDescription = "Android Icon",
                                )
                                Icon(
                                    modifier = Modifier.size(35.dp),
                                    painter = painterResource(R.drawable.ic_report),
                                    tint = MaterialTheme.colorScheme.error,
                                    contentDescription = "Android Icon",
                                )
                            }

                            Text(
                                text = permission.title,
                                maxLines = 1,
                                style = MaterialTheme.typography.titleMedium,
                            )

                            Text(
                                text = "Request Access",
                                style = MaterialTheme.typography.titleSmall,
                                maxLines = 1,
                                color = MaterialTheme.colorScheme.tertiary
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DashboardScreenPreview() {
    MaterialTheme {
        RuntimePermissionsView()
    }
}