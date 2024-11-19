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

public val SeeDocsIcon.RecentFill: ImageVector
    get() {
        if (kr.co.ui.icon.seedocsicon._recentFill != null) {
            return kr.co.ui.icon.seedocsicon._recentFill!!
        }
        kr.co.ui.icon.seedocsicon._recentFill = Builder(name = "RecentFill", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1B1C1E)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(12.0f, 10.85f)
                    lineTo(6.075f, 7.425f)
                    lineTo(5.0f, 8.05f)
                    verticalLineTo(9.1f)
                    lineTo(12.0f, 13.15f)
                    lineTo(19.0f, 9.1f)
                    verticalLineTo(8.05f)
                    lineTo(17.925f, 7.425f)
                    lineTo(12.0f, 10.85f)
                    close()
                    moveTo(11.0f, 21.725f)
                    lineTo(4.0f, 17.7f)
                    curveTo(3.6833f, 17.5167f, 3.4375f, 17.275f, 3.2625f, 16.975f)
                    curveTo(3.0875f, 16.675f, 3.0f, 16.3417f, 3.0f, 15.975f)
                    verticalLineTo(8.025f)
                    curveTo(3.0f, 7.6583f, 3.0875f, 7.325f, 3.2625f, 7.025f)
                    curveTo(3.4375f, 6.725f, 3.6833f, 6.4833f, 4.0f, 6.3f)
                    lineTo(11.0f, 2.275f)
                    curveTo(11.3167f, 2.0917f, 11.65f, 2.0f, 12.0f, 2.0f)
                    curveTo(12.35f, 2.0f, 12.6833f, 2.0917f, 13.0f, 2.275f)
                    lineTo(20.0f, 6.3f)
                    curveTo(20.3167f, 6.4833f, 20.5625f, 6.725f, 20.7375f, 7.025f)
                    curveTo(20.9125f, 7.325f, 21.0f, 7.6583f, 21.0f, 8.025f)
                    verticalLineTo(12.675f)
                    curveTo(20.55f, 12.4583f, 20.0708f, 12.2917f, 19.5625f, 12.175f)
                    curveTo(19.0542f, 12.0583f, 18.5333f, 12.0f, 18.0f, 12.0f)
                    curveTo(16.0667f, 12.0f, 14.4167f, 12.6833f, 13.05f, 14.05f)
                    curveTo(11.6833f, 15.4167f, 11.0f, 17.0667f, 11.0f, 19.0f)
                    curveTo(11.0f, 19.5333f, 11.0542f, 20.0458f, 11.1625f, 20.5375f)
                    curveTo(11.2708f, 21.0292f, 11.4333f, 21.5f, 11.65f, 21.95f)
                    curveTo(11.5333f, 21.9167f, 11.4208f, 21.8875f, 11.3125f, 21.8625f)
                    curveTo(11.2042f, 21.8375f, 11.1f, 21.7917f, 11.0f, 21.725f)
                    close()
                    moveTo(18.0f, 24.0f)
                    curveTo(16.6167f, 24.0f, 15.4375f, 23.5125f, 14.4625f, 22.5375f)
                    curveTo(13.4875f, 21.5625f, 13.0f, 20.3833f, 13.0f, 19.0f)
                    curveTo(13.0f, 17.6167f, 13.4875f, 16.4375f, 14.4625f, 15.4625f)
                    curveTo(15.4375f, 14.4875f, 16.6167f, 14.0f, 18.0f, 14.0f)
                    curveTo(19.3833f, 14.0f, 20.5625f, 14.4875f, 21.5375f, 15.4625f)
                    curveTo(22.5125f, 16.4375f, 23.0f, 17.6167f, 23.0f, 19.0f)
                    curveTo(23.0f, 20.3833f, 22.5125f, 21.5625f, 21.5375f, 22.5375f)
                    curveTo(20.5625f, 23.5125f, 19.3833f, 24.0f, 18.0f, 24.0f)
                    close()
                    moveTo(18.5f, 18.8f)
                    verticalLineTo(16.0f)
                    horizontalLineTo(17.5f)
                    verticalLineTo(19.2f)
                    lineTo(19.65f, 21.35f)
                    lineTo(20.35f, 20.65f)
                    lineTo(18.5f, 18.8f)
                    close()
                }
            }
        }
        .build()
        return kr.co.ui.icon.seedocsicon._recentFill!!
    }

private var _recentFill: ImageVector? = null
