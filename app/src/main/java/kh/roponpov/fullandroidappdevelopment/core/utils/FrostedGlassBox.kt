package kh.roponpov.fullandroidappdevelopment.core.utils

import android.graphics.RenderEffect as AndroidRenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.asComposeRenderEffect

@Composable
fun FrostedGlassBox(
    modifier: Modifier = Modifier,
    overlayColor: Color = Color.White.copy(alpha = 0.15f),
    shape: Shape = RoundedCornerShape(24.dp),
    content: @Composable () -> Unit
) {
    Box(modifier = modifier.clip(shape)) {

        // Layer 1: Blurred background only
        Box(
            modifier = Modifier
                .matchParentSize()
                .graphicsLayer {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                        renderEffect = AndroidRenderEffect
                            .createBlurEffect(40f, 40f, Shader.TileMode.CLAMP)
                            .asComposeRenderEffect()
                    }
                }
                .background(overlayColor)
        )

        // Layer 2: Sharp content on top — NOT blurred
        content()
    }
}