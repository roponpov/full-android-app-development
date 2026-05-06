package kh.roponpov.fullandroidappdevelopment.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomTab(
    override val route: String,
    val label: String,
    val icon: ImageVector
) : AppRoute {
    data object Dashboard : BottomTab("dashboard_graph", "Dashboard", Icons.Default.Home)
    data object Search : BottomTab("search_graph", "Search", Icons.Default.Search)
    data object Profile : BottomTab("profile_graph", "Profile", Icons.Default.Person)
}
