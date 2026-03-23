package kh.roponpov.fullandroidappdevelopment.features.main.views

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavHost
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavigatorImpl

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navigator = remember { AppNavigatorImpl(navController) }

    Scaffold(
        bottomBar = {
            BottomBar(navigator, navController)
        }
    ) { padding ->
        AppNavHost(
            navController = navController,
            navigator = navigator,
            modifier = Modifier.padding(padding)
        )
    }
}