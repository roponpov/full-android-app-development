package kh.roponpov.fullandroidappdevelopment.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.ActivityNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.features.splash.view.SplashView

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Destinations.Splash.route,
    ) {
        composable(Destinations.Splash.route) {
            SplashView()
        }
    }
}