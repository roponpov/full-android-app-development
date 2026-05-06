package kh.roponpov.fullandroidappdevelopment.features.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.core.navigation.BottomTab
import kh.roponpov.fullandroidappdevelopment.features.search.views.SearchView

fun NavGraphBuilder.searchGraphNavigation(
    navigator: AppNavigator
) {
    navigation(
        route = "search_graph",
        startDestination = "search",
    ) {

        composable("search") {
            SearchView(
                onNavigateDetail = {
                    navigator.navigateTo("search_detail")
                }
            )
        }

//        composable("home_detail") {
//            HomeDetailScreen()
//        }
    }
}