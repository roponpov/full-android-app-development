package kh.roponpov.fullandroidappdevelopment.core.navigation

sealed class BottomTab(override val route: String) : AppRoute {
    data object Dashboard : BottomTab("dashboard_graph")
    data object Search : BottomTab("search_graph")
    data object Profile : BottomTab("profile_graph")
}