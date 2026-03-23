package kh.roponpov.fullandroidappdevelopment.core.navigation

import androidx.navigation.NavHostController

class AppNavigatorImpl(
    private val navController: NavHostController
) : AppNavigator {

    override fun navigateToTab(tab: BottomTab) {
        navController.navigate(tab.route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    override fun navigateTo(route: String) {
        navController.navigate(route)
    }

    override fun goBack() {
        navController.popBackStack()
    }
}