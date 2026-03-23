package kh.roponpov.fullandroidappdevelopment.core.navigation

interface AppNavigator {
    fun navigateToTab(tab: BottomTab)
    fun navigateTo(route: String)
    fun goBack()
}