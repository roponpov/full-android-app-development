package kh.roponpov.fullandroidappdevelopment.features.splash.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SplashView(){
    Scaffold() { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text("Splash View")
        }
    }
}