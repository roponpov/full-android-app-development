package kh.roponpov.fullandroidappdevelopment.features.main.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigator
import kh.roponpov.fullandroidappdevelopment.core.navigation.BottomTab

@Composable
fun BottomBar(
    navigator: AppNavigator,
    navController: NavHostController
) {
    val currentRoute = navController
        .currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        listOf(
            BottomTab.Dashboard,
            BottomTab.Search,
            BottomTab.Profile
        ).forEach { tab ->

            NavigationBarItem(
                selected = currentRoute?.startsWith(tab.route) == true,
                onClick = { navigator.navigateToTab(tab) },
                icon = { Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = null,
                ) },
                label = { Text(tab.route) }
            )
        }
    }
}