package kh.roponpov.fullandroidappdevelopment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import kh.roponpov.fullandroidappdevelopment.core.ui.theme.FullAndroidAppDevelopmentTheme
import kh.roponpov.fullandroidappdevelopment.features.main.views.MainScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FullAndroidAppDevelopmentTheme {
                MainScreen()
            }
        }
    }
}