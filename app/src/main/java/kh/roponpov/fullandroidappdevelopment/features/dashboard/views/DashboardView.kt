package kh.roponpov.fullandroidappdevelopment.features.dashboard.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardView(
    onNavigateDetail: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Good Morning")
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
                .fillMaxSize()
                .background(
                    color = MaterialTheme.colorScheme.primary
                ),
        ){
            Text("DASHBOARD")
        }
    }
}