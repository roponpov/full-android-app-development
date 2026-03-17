package kh.roponpov.fullandroidappdevelopment.core.navigation
import androidx.navigation.NavHostController

class Navigator(private val navController: NavHostController) {
    fun navigateTo(route: String) {
        navController.navigate(route)
    }

    fun goBack() {
        navController.popBackStack()
    }
}