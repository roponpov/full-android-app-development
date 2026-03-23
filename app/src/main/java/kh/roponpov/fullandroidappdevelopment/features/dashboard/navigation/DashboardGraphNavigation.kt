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
        startDestination = "dashboard",
        route = BottomTab.Dashboard.route
    ) {

        composable("dashboard") {
            DashboardView(
                onNavigateDetail = {
                    navigator.navigateTo("dashboard_detail")
                }
            )
        }

//        composable("home_detail") {
//            HomeDetailScreen()
//        }
    }
}