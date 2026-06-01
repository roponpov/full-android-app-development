package kh.roponpov.fullandroidappdevelopment.features.dashboard.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.features.dashboard.views.DashboardView
import kh.roponpov.fullandroidappdevelopment.features.aba_dashboard.views.ABADashboardView
import kh.roponpov.fullandroidappdevelopment.features.runtime_permission.views.RuntimePermissionsView

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
            RuntimePermissionsView(
                navigator = navigator
            )
        }
        composable("mobile_banking") {
            ABADashboardView(
                navigator = navigator
            )
        }

//        composable("home_detail") {
//            HomeDetailScreen()
//        }
    }
}
