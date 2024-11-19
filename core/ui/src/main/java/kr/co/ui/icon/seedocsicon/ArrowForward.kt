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

public val SeeDocsIcon.ArrowForward: ImageVector
    get() {
        if (kr.co.ui.icon.seedocsicon._arrowForward != null) {
            return kr.co.ui.icon.seedocsicon._arrowForward!!
        }
        kr.co.ui.icon.seedocsicon._arrowForward = Builder(name = "ArrowForward", defaultWidth = 24.0.dp, defaultHeight =
                24.0.dp, viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1C1B1F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(8.025f, 22.0f)
                    lineTo(6.25f, 20.225f)
                    lineTo(14.475f, 12.0f)
                    lineTo(6.25f, 3.775f)
                    lineTo(8.025f, 2.0f)
                    lineTo(18.025f, 12.0f)
                    lineTo(8.025f, 22.0f)
                    close()
                }
            }
        }
        .build()
        return kr.co.ui.icon.seedocsicon._arrowForward!!
    }

private var _arrowForward: ImageVector? = null
