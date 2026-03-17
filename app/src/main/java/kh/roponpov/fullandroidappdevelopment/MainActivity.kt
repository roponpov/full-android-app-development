package kh.roponpov.fullandroidappdevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import kh.roponpov.fullandroidappdevelopment.core.navigation.AppNavHost
import kh.roponpov.fullandroidappdevelopment.core.ui.theme.FullAndroidAppDevelopmentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FullAndroidAppDevelopmentTheme {
                AppNavHost()
            }
        }
    }
}