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

public val SeeDocsIcon.Close: ImageVector
    get() {
        if (_close != null) {
            return _close!!
        }
        _close = Builder(name = "Close", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1C1B1F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(6.4f, 19.0f)
                    lineTo(5.0f, 17.6f)
                    lineTo(10.6f, 12.0f)
                    lineTo(5.0f, 6.4f)
                    lineTo(6.4f, 5.0f)
                    lineTo(12.0f, 10.6f)
                    lineTo(17.6f, 5.0f)
                    lineTo(19.0f, 6.4f)
                    lineTo(13.4f, 12.0f)
                    lineTo(19.0f, 17.6f)
                    lineTo(17.6f, 19.0f)
                    lineTo(12.0f, 13.4f)
                    lineTo(6.4f, 19.0f)
                    close()
                }
            }
        }
        .build()
        return _close!!
    }

private var _close: ImageVector? = null
