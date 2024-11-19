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

public val SeeDocsIcon.Explore: ImageVector
    get() {
        if (_explore != null) {
            return _explore!!
        }
        _explore = Builder(name = "Explore", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1B1C1E)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(2.0f, 19.0f)
                    verticalLineTo(17.0f)
                    horizontalLineTo(12.0f)
                    verticalLineTo(19.0f)
                    horizontalLineTo(2.0f)
                    close()
                    moveTo(2.0f, 14.0f)
                    verticalLineTo(12.0f)
                    horizontalLineTo(7.0f)
                    verticalLineTo(14.0f)
                    horizontalLineTo(2.0f)
                    close()
                    moveTo(2.0f, 9.0f)
                    verticalLineTo(7.0f)
                    horizontalLineTo(7.0f)
                    verticalLineTo(9.0f)
                    horizontalLineTo(2.0f)
                    close()
                    moveTo(20.6f, 19.0f)
                    lineTo(16.75f, 15.15f)
                    curveTo(16.35f, 15.4333f, 15.9125f, 15.6458f, 15.4375f, 15.7875f)
                    curveTo(14.9625f, 15.9292f, 14.4833f, 16.0f, 14.0f, 16.0f)
                    curveTo(12.6167f, 16.0f, 11.4375f, 15.5125f, 10.4625f, 14.5375f)
                    curveTo(9.4875f, 13.5625f, 9.0f, 12.3833f, 9.0f, 11.0f)
                    curveTo(9.0f, 9.6167f, 9.4875f, 8.4375f, 10.4625f, 7.4625f)
                    curveTo(11.4375f, 6.4875f, 12.6167f, 6.0f, 14.0f, 6.0f)
                    curveTo(15.3833f, 6.0f, 16.5625f, 6.4875f, 17.5375f, 7.4625f)
                    curveTo(18.5125f, 8.4375f, 19.0f, 9.6167f, 19.0f, 11.0f)
                    curveTo(19.0f, 11.4833f, 18.9292f, 11.9625f, 18.7875f, 12.4375f)
                    curveTo(18.6458f, 12.9125f, 18.4333f, 13.35f, 18.15f, 13.75f)
                    lineTo(22.0f, 17.6f)
                    lineTo(20.6f, 19.0f)
                    close()
                    moveTo(14.0f, 14.0f)
                    curveTo(14.8333f, 14.0f, 15.5417f, 13.7083f, 16.125f, 13.125f)
                    curveTo(16.7083f, 12.5417f, 17.0f, 11.8333f, 17.0f, 11.0f)
                    curveTo(17.0f, 10.1667f, 16.7083f, 9.4583f, 16.125f, 8.875f)
                    curveTo(15.5417f, 8.2917f, 14.8333f, 8.0f, 14.0f, 8.0f)
                    curveTo(13.1667f, 8.0f, 12.4583f, 8.2917f, 11.875f, 8.875f)
                    curveTo(11.2917f, 9.4583f, 11.0f, 10.1667f, 11.0f, 11.0f)
                    curveTo(11.0f, 11.8333f, 11.2917f, 12.5417f, 11.875f, 13.125f)
                    curveTo(12.4583f, 13.7083f, 13.1667f, 14.0f, 14.0f, 14.0f)
                    close()
                }
            }
        }
        .build()
        return _explore!!
    }

private var _explore: ImageVector? = null
