package kh.roponpov.fullandroidappdevelopment.features.profile.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.features.profile.views.ProfileView
import kh.roponpov.fullandroidappdevelopment.features.search.views.SearchView

fun NavGraphBuilder.profileGraphNavigation(
    navigator: AppNavigator
) {
    navigation(
        route = "profile_graph",
        startDestination = "profile",
    ) {

        composable("profile") {
            ProfileView(
                onNavigateDetail = {
                    navigator.navigateTo("profile_detail")
                }
            )
        }

//        composable("home_detail") {
//            HomeDetailScreen()
//        }
    }
}