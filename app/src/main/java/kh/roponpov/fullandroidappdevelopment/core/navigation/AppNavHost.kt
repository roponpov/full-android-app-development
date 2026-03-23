package kh.roponpov.fullandroidappdevelopment.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import kh.roponpov.fullandroidappdevelopment.features.dashboard.navigation.dashboardGraphNavigation

@Composable
fun AppNavHost(
    navController: NavHostController,
    navigator: AppNavigator,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = BottomTab.Dashboard.route,
        modifier = modifier
    ) {
        dashboardGraphNavigation(navigator)
//        searchGraph()
//        profileGraph()
    }
}