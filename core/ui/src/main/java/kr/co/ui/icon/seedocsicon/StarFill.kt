package kr.co.ui.icon.seedocsicon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.co.ui.icon.SeeDocsIcon

public val SeeDocsIcon.StarFill: ImageVector
    get() {
        if (kr.co.ui.icon.seedocsicon._starFill != null) {
            return kr.co.ui.icon.seedocsicon._starFill!!
        }
        kr.co.ui.icon.seedocsicon._starFill = Builder(name = "StarFill", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1B1C1E)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(7.625f, 6.4f)
                    lineTo(10.425f, 2.775f)
                    curveTo(10.625f, 2.5083f, 10.8625f, 2.3125f, 11.1375f, 2.1875f)
                    curveTo(11.4125f, 2.0625f, 11.7f, 2.0f, 12.0f, 2.0f)
                    curveTo(12.3f, 2.0f, 12.5875f, 2.0625f, 12.8625f, 2.1875f)
                    curveTo(13.1375f, 2.3125f, 13.375f, 2.5083f, 13.575f, 2.775f)
                    lineTo(16.375f, 6.4f)
                    lineTo(20.625f, 7.825f)
                    curveTo(21.0583f, 7.9583f, 21.4f, 8.2042f, 21.65f, 8.5625f)
                    curveTo(21.9f, 8.9208f, 22.025f, 9.3167f, 22.025f, 9.75f)
                    curveTo(22.025f, 9.95f, 21.9958f, 10.15f, 21.9375f, 10.35f)
                    curveTo(21.8792f, 10.55f, 21.7833f, 10.7417f, 21.65f, 10.925f)
                    lineTo(18.9f, 14.825f)
                    lineTo(19.0f, 18.925f)
                    curveTo(19.0167f, 19.5083f, 18.825f, 20.0f, 18.425f, 20.4f)
                    curveTo(18.025f, 20.8f, 17.5583f, 21.0f, 17.025f, 21.0f)
                    curveTo(16.9917f, 21.0f, 16.8083f, 20.975f, 16.475f, 20.925f)
                    lineTo(12.0f, 19.675f)
                    lineTo(7.525f, 20.925f)
                    curveTo(7.4417f, 20.9583f, 7.35f, 20.9792f, 7.25f, 20.9875f)
                    curveTo(7.15f, 20.9958f, 7.0583f, 21.0f, 6.975f, 21.0f)
                    curveTo(6.4417f, 21.0f, 5.975f, 20.8f, 5.575f, 20.4f)
                    curveTo(5.175f, 20.0f, 4.9833f, 19.5083f, 5.0f, 18.925f)
                    lineTo(5.1f, 14.8f)
                    lineTo(2.375f, 10.925f)
                    curveTo(2.2417f, 10.7417f, 2.1458f, 10.55f, 2.0875f, 10.35f)
                    curveTo(2.0292f, 10.15f, 2.0f, 9.95f, 2.0f, 9.75f)
                    curveTo(2.0f, 9.3333f, 2.1208f, 8.9458f, 2.3625f, 8.5875f)
                    curveTo(2.6042f, 8.2292f, 2.9417f, 7.975f, 3.375f, 7.825f)
                    lineTo(7.625f, 6.4f)
                    close()
                }
            }
        }
        .build()
        return kr.co.ui.icon.seedocsicon._starFill!!
    }

private var _starFill: ImageVector? = null
