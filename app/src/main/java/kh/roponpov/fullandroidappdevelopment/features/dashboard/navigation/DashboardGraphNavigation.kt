package kh.roponpov.fullandroidappdevelopment.features.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.core.navigation.BottomTab
import kh.roponpov.fullandroidappdevelopment.features.dashboard.views.DashboardView

fun NavGraphBuilder.dashboardGraphNavigation(
    navigator: AppNavigator
) {
    navigation(
        route = "dashboard_graph",
        startDestination = "dashboard",
    ) {

        composable("dashboard") {
            DashboardView(
                onNavigateDetail = { route ->
                    navigator.navigateTo(route)
                }
            )
        }
        composable("runtime_permission") {
//            DashboardView()
        }

//        composable("home_detail") {
//            HomeDetailScreen()
//        }
    }
}
