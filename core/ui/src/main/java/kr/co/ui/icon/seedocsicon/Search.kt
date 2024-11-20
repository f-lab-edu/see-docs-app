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

public val SeeDocsIcon.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(name = "Search", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1C1B1F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(19.6f, 21.0f)
                    lineTo(13.3f, 14.7f)
                    curveTo(12.8f, 15.1f, 12.225f, 15.4167f, 11.575f, 15.65f)
                    curveTo(10.925f, 15.8833f, 10.2333f, 16.0f, 9.5f, 16.0f)
                    curveTo(7.6833f, 16.0f, 6.1458f, 15.3708f, 4.8875f, 14.1125f)
                    curveTo(3.6292f, 12.8542f, 3.0f, 11.3167f, 3.0f, 9.5f)
                    curveTo(3.0f, 7.6833f, 3.6292f, 6.1458f, 4.8875f, 4.8875f)
                    curveTo(6.1458f, 3.6292f, 7.6833f, 3.0f, 9.5f, 3.0f)
                    curveTo(11.3167f, 3.0f, 12.8542f, 3.6292f, 14.1125f, 4.8875f)
                    curveTo(15.3708f, 6.1458f, 16.0f, 7.6833f, 16.0f, 9.5f)
                    curveTo(16.0f, 10.2333f, 15.8833f, 10.925f, 15.65f, 11.575f)
                    curveTo(15.4167f, 12.225f, 15.1f, 12.8f, 14.7f, 13.3f)
                    lineTo(21.0f, 19.6f)
                    lineTo(19.6f, 21.0f)
                    close()
                    moveTo(9.5f, 14.0f)
                    curveTo(10.75f, 14.0f, 11.8125f, 13.5625f, 12.6875f, 12.6875f)
                    curveTo(13.5625f, 11.8125f, 14.0f, 10.75f, 14.0f, 9.5f)
                    curveTo(14.0f, 8.25f, 13.5625f, 7.1875f, 12.6875f, 6.3125f)
                    curveTo(11.8125f, 5.4375f, 10.75f, 5.0f, 9.5f, 5.0f)
                    curveTo(8.25f, 5.0f, 7.1875f, 5.4375f, 6.3125f, 6.3125f)
                    curveTo(5.4375f, 7.1875f, 5.0f, 8.25f, 5.0f, 9.5f)
                    curveTo(5.0f, 10.75f, 5.4375f, 11.8125f, 6.3125f, 12.6875f)
                    curveTo(7.1875f, 13.5625f, 8.25f, 14.0f, 9.5f, 14.0f)
                    close()
                }
            }
        }
        .build()
        return _search!!
    }

private var _search: ImageVector? = null
