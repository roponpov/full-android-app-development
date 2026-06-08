package kh.roponpov.fullandroidappdevelopment.core.extensions

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asComposeRenderEffect
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@SuppressLint("SuspiciousModifierThen")
fun Modifier.blurBackground(blurRadius: Dp = 20.dp): Modifier = this.then(
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        graphicsLayer {
            renderEffect = BlurMaskFilter(blurRadius.toPx(), BlurMaskFilter.Blur.NORMAL)
                .let { RenderEffect.createBlurEffect(blurRadius.toPx(), blurRadius.toPx(), Shader.TileMode.CLAMP) }
                .asComposeRenderEffect()
        }
    } else Modifier
)