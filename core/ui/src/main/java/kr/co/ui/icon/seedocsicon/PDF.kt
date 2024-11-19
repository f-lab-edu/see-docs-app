package kr.co.ui.icon.seedocsicon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.co.ui.icon.SeeDocsIcon

public val SeeDocsIcon.PDF: ImageVector
    get() {
        if (_PDF != null) {
            return _PDF!!
        }
        _PDF = Builder(name = "Frame 22", defaultWidth = 35.0.dp, defaultHeight = 32.0.dp,
                viewportWidth = 35.0f, viewportHeight = 32.0f).apply {
            path(fill = SolidColor(Color(0xFFD82D2D)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0f, 0.0f)
                lineTo(31.0f, 0.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 35.0f, 4.0f)
                lineTo(35.0f, 28.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 31.0f, 32.0f)
                lineTo(4.0f, 32.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 0.0f, 28.0f)
                lineTo(0.0f, 4.0f)
                arcTo(4.0f, 4.0f, 0.0f, false, true, 4.0f, 0.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFffffff)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.916f, 11.1016f)
                horizontalLineTo(8.6348f)
                curveTo(9.373f, 11.1016f, 10.0042f, 11.2406f, 10.5283f, 11.5186f)
                curveTo(11.0524f, 11.7965f, 11.4489f, 12.1839f, 11.7178f, 12.6807f)
                curveTo(11.9867f, 13.1729f, 12.1211f, 13.7402f, 12.1211f, 14.3828f)
                curveTo(12.1211f, 15.0208f, 11.9844f, 15.5882f, 11.7109f, 16.085f)
                curveTo(11.4421f, 16.5771f, 11.0433f, 16.9622f, 10.5146f, 17.2402f)
                curveTo(9.986f, 17.5137f, 9.3503f, 17.6504f, 8.6074f, 17.6504f)
                horizontalLineTo(6.6934f)
                verticalLineTo(21.0f)
                horizontalLineTo(4.916f)
                verticalLineTo(11.1016f)
                close()
                moveTo(8.3613f, 16.1875f)
                curveTo(9.0085f, 16.1875f, 9.4938f, 16.0257f, 9.8174f, 15.7021f)
                curveTo(10.141f, 15.374f, 10.3027f, 14.9342f, 10.3027f, 14.3828f)
                curveTo(10.3027f, 13.8268f, 10.141f, 13.3893f, 9.8174f, 13.0703f)
                curveTo(9.4938f, 12.7513f, 9.0085f, 12.5918f, 8.3613f, 12.5918f)
                horizontalLineTo(6.6934f)
                verticalLineTo(16.1875f)
                horizontalLineTo(8.3613f)
                close()
                moveTo(13.5566f, 21.0f)
                verticalLineTo(11.1016f)
                horizontalLineTo(16.9746f)
                curveTo(17.9544f, 11.1016f, 18.7998f, 11.2998f, 19.5107f, 11.6963f)
                curveTo(20.2217f, 12.0882f, 20.7663f, 12.6556f, 21.1445f, 13.3984f)
                curveTo(21.5273f, 14.1413f, 21.7188f, 15.0208f, 21.7188f, 16.0371f)
                curveTo(21.7188f, 17.0625f, 21.5273f, 17.9489f, 21.1445f, 18.6963f)
                curveTo(20.7617f, 19.4391f, 20.2103f, 20.0088f, 19.4902f, 20.4053f)
                curveTo(18.7702f, 20.8018f, 17.9134f, 21.0f, 16.9199f, 21.0f)
                horizontalLineTo(13.5566f)
                close()
                moveTo(16.8242f, 19.4551f)
                curveTo(17.8587f, 19.4551f, 18.6357f, 19.1702f, 19.1553f, 18.6006f)
                curveTo(19.6794f, 18.0309f, 19.9414f, 17.1764f, 19.9414f, 16.0371f)
                curveTo(19.9414f, 14.9069f, 19.6839f, 14.0592f, 19.1689f, 13.4941f)
                curveTo(18.654f, 12.929f, 17.8906f, 12.6465f, 16.8789f, 12.6465f)
                horizontalLineTo(15.334f)
                verticalLineTo(19.4551f)
                horizontalLineTo(16.8242f)
                close()
                moveTo(23.291f, 11.1016f)
                horizontalLineTo(29.6348f)
                verticalLineTo(12.5918f)
                horizontalLineTo(25.0684f)
                verticalLineTo(15.2988f)
                horizontalLineTo(29.1973f)
                verticalLineTo(16.7891f)
                horizontalLineTo(25.0684f)
                verticalLineTo(21.0f)
                horizontalLineTo(23.291f)
                verticalLineTo(11.1016f)
                close()
            }
        }
        .build()
        return _PDF!!
    }

private var _PDF: ImageVector? = null
