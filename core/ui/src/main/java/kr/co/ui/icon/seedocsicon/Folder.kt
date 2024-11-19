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

public val SeeDocsIcon.Folder: ImageVector
    get() {
        if (_folder != null) {
            return _folder!!
        }
        _folder = Builder(name = "Folder", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFFB5B5B5)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(4.0f, 20.0f)
                    curveTo(3.45f, 20.0f, 2.9792f, 19.8042f, 2.5875f, 19.4125f)
                    curveTo(2.1958f, 19.0208f, 2.0f, 18.55f, 2.0f, 18.0f)
                    verticalLineTo(6.0f)
                    curveTo(2.0f, 5.45f, 2.1958f, 4.9792f, 2.5875f, 4.5875f)
                    curveTo(2.9792f, 4.1958f, 3.45f, 4.0f, 4.0f, 4.0f)
                    horizontalLineTo(10.0f)
                    lineTo(12.0f, 6.0f)
                    horizontalLineTo(20.0f)
                    curveTo(20.55f, 6.0f, 21.0208f, 6.1958f, 21.4125f, 6.5875f)
                    curveTo(21.8042f, 6.9792f, 22.0f, 7.45f, 22.0f, 8.0f)
                    verticalLineTo(18.0f)
                    curveTo(22.0f, 18.55f, 21.8042f, 19.0208f, 21.4125f, 19.4125f)
                    curveTo(21.0208f, 19.8042f, 20.55f, 20.0f, 20.0f, 20.0f)
                    horizontalLineTo(4.0f)
                    close()
                }
            }
        }
        .build()
        return _folder!!
    }

private var _folder: ImageVector? = null
