package kh.roponpov.fullandroidappdevelopment.features.splash.view

import android.content.res.Configuration
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kh.roponpov.fullandroidappdevelopment.R
import kh.roponpov.fullandroidappdevelopment.features.splash.view.sections.ProgressBarIndicatorSection

@Composable
fun SplashView() {
    //////////////////////////////
    //// VARIABLE DECLARATION ////
    //////////////////////////////
    val infiniteTransition = rememberInfiniteTransition(label = "PulseTransition")
    val scale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.08f,
        animationSpec = infiniteRepeatable(
            animation = tween(1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "LogoScale"
    )

    // 2. Main Container with a fixed Radial Gradient
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(
                        Color(0xFF1E1B4B),
                        Color(0xFF0F0E17)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {
            //////////////////////////////
            //// ANDROID LOGO SECTION ////
            //////////////////////////////
            Box(
                modifier = Modifier
                    .graphicsLayer(scaleX = scale, scaleY = scale) // Apply pulse
                    .background(
                        color = Color.White.copy(alpha = 0.05f),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .border(
                        width = 1.dp,
                        brush = Brush.linearGradient(
                            listOf(Color.White.copy(alpha = 0.2f), Color.Transparent)
                        ),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .padding(32.dp),
            ) {
                Icon(
                    modifier = Modifier.size(64.dp),
                    painter = painterResource(R.drawable.android_logo),
                    tint = MaterialTheme.colorScheme.primary,
                    contentDescription = "Android Logo",
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            /////////////////////////////////////
            //// ANDROID STUDIO TEXT SECTION ////
            /////////////////////////////////////
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Android",
                    style = MaterialTheme.typography.displaySmall.copy(
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                    )
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Studio",
                    style = MaterialTheme.typography.displaySmall.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold,
                    )
                )
            }

            Text(
                text = "FULL APP DEVELOPMENT",
                style = MaterialTheme.typography.labelLarge.copy(
                    color = Color.White.copy(alpha = 0.5f),
                    letterSpacing = 5.sp,
                    fontWeight = FontWeight.Medium
                )
            )

            Spacer(modifier = Modifier.height(48.dp))

            //////////////////////////////
            //// PROGRESS BAR SECTION ////
            //////////////////////////////
            ProgressBarIndicatorSection()
        }

        ////////////////////////////////////
        //// POWERED BUY GOOGLE SECTION ////
        ////////////////////////////////////
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Powered by",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.White.copy(0.4f)
                    )
                )
                Image(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.ic_google_logo),
                    contentDescription = "Google Logo"
                )
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun PreviewSplash() {
    MaterialTheme {
        SplashView()
    }
}