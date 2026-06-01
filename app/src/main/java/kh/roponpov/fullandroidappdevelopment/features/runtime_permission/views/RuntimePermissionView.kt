package kh.roponpov.fullandroidappdevelopment.features.runtime_permission.views

import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.features.runtime_permission.models.RuntimePermissionModel

@OptIn(ExperimentalMaterial3Api::class, ExperimentalPermissionsApi::class)
@Composable
fun RuntimePermissionsView(
    navigator: AppNavigator,
) {
    val context = LocalContext.current

    Scaffold(
        contentWindowInsets = WindowInsets.safeDrawing,
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            TopAppBar(
                windowInsets = WindowInsets(0, 0, 0, 0),
                navigationIcon = {
                    IconButton(onClick = { navigator.goBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
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
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            val runtimePermissions = RuntimePermissionModel.runtimePermissions
            val runtimePermissionLength: Int = runtimePermissions.count()

            items(runtimePermissionLength) {
                val runtimePermission = runtimePermissions[it]

                Text(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            bottom = 16.dp,
                            start = 16.dp,
                        ),
                    text = runtimePermission.groupPermissionTitle.uppercase(),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.titleMedium,
                )

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    runtimePermission.permissions.forEach { permission ->
                        val cameraPermissionState = rememberPermissionState(permission.permission)
                        val isPermissionEnabled = cameraPermissionState.status.isGranted
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    horizontal = 16.dp,
                                ),
                            horizontalArrangement = Arrangement.spacedBy(
                                alignment = Alignment.CenterHorizontally,
                                space = 16.dp,
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier.size(35.dp),
                                painter = painterResource(permission.iconRes),
                                tint = MaterialTheme.colorScheme.onBackground,
                                contentDescription = "Android Icon",
                            )
                            Column (
                                modifier = Modifier.weight(1f)
                            ){
                                Text(
                                    text = permission.title,
                                    style = MaterialTheme.typography.titleMedium,
                                    maxLines = 1,
                                )
                                Text(
                                    text = permission.description,
                                    style = MaterialTheme.typography.labelSmall,
                                    maxLines = 2,
                                )
                            }

                            Switch(
                                checked = isPermissionEnabled,
                                onCheckedChange = { status ->
                                    if(status) {
                                        cameraPermissionState.launchPermissionRequest()
                                        return@Switch
                                    } else {
                                        val intent = Intent(
                                            Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                                            Uri.fromParts(
                                                "package",
                                                context.packageName,
                                                null,
                                            ),
                                        )
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        context.startActivity(intent)
                                        return@Switch
                                    }
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}