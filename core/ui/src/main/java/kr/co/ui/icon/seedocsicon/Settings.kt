package kr.co.ui.icon.seedocsicon

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import kr.co.ui.icon.SeeDocsIcon

public val SeeDocsIcon.Settings: ImageVector
    get() {
        if (_settings != null) {
            return _settings!!
        }
        _settings = Builder(name = "Settings", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF1C1B1F)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = EvenOdd) {
                    moveTo(8.85f, 18.8f)
                    lineTo(9.25f, 22.0f)
                    horizontalLineTo(14.75f)
                    lineTo(15.15f, 18.8f)
                    curveTo(15.35f, 18.7167f, 15.55f, 18.6167f, 15.75f, 18.5f)
                    curveTo(15.95f, 18.3833f, 16.1417f, 18.2583f, 16.325f, 18.125f)
                    lineTo(19.275f, 19.375f)
                    lineTo(22.025f, 14.625f)
                    lineTo(19.45f, 12.675f)
                    curveTo(19.4833f, 12.5583f, 19.5f, 12.4458f, 19.5f, 12.3375f)
                    verticalLineTo(11.6625f)
                    curveTo(19.5f, 11.5542f, 19.4917f, 11.4417f, 19.475f, 11.325f)
                    lineTo(22.05f, 9.375f)
                    lineTo(19.3f, 4.625f)
                    lineTo(16.325f, 5.875f)
                    curveTo(16.1417f, 5.7417f, 15.9542f, 5.6167f, 15.7625f, 5.5f)
                    curveTo(15.5708f, 5.3833f, 15.3667f, 5.2833f, 15.15f, 5.2f)
                    lineTo(14.75f, 2.0f)
                    horizontalLineTo(9.25f)
                    lineTo(8.85f, 5.2f)
                    curveTo(8.65f, 5.2833f, 8.45f, 5.3833f, 8.25f, 5.5f)
                    curveTo(8.05f, 5.6167f, 7.8583f, 5.7417f, 7.675f, 5.875f)
                    lineTo(4.7f, 4.625f)
                    lineTo(1.95f, 9.375f)
                    lineTo(4.525f, 11.325f)
                    curveTo(4.5083f, 11.4417f, 4.5f, 11.5542f, 4.5f, 11.6625f)
                    verticalLineTo(12.3375f)
                    curveTo(4.5f, 12.4458f, 4.5083f, 12.5583f, 4.525f, 12.675f)
                    lineTo(1.95f, 14.625f)
                    lineTo(4.7f, 19.375f)
                    lineTo(7.675f, 18.125f)
                    curveTo(7.8583f, 18.2583f, 8.0458f, 18.3833f, 8.2375f, 18.5f)
                    curveTo(8.4292f, 18.6167f, 8.6333f, 18.7167f, 8.85f, 18.8f)
                    close()
                    moveTo(12.975f, 20.0f)
                    horizontalLineTo(11.0f)
                    lineTo(10.675f, 17.35f)
                    curveTo(10.1583f, 17.2167f, 9.6792f, 17.0208f, 9.2375f, 16.7625f)
                    curveTo(8.7958f, 16.5042f, 8.3917f, 16.1833f, 8.025f, 15.8f)
                    lineTo(5.55f, 16.85f)
                    lineTo(4.575f, 15.15f)
                    lineTo(6.725f, 13.525f)
                    curveTo(6.6417f, 13.275f, 6.5833f, 13.025f, 6.55f, 12.775f)
                    curveTo(6.5167f, 12.525f, 6.5f, 12.2667f, 6.5f, 12.0f)
                    curveTo(6.5f, 11.7167f, 6.5167f, 11.45f, 6.55f, 11.2f)
                    curveTo(6.5833f, 10.95f, 6.6417f, 10.7f, 6.725f, 10.45f)
                    lineTo(4.575f, 8.85f)
                    lineTo(5.55f, 7.15f)
                    lineTo(8.025f, 8.175f)
                    curveTo(8.3917f, 7.8083f, 8.7958f, 7.4958f, 9.2375f, 7.2375f)
                    curveTo(9.6792f, 6.9792f, 10.1583f, 6.7833f, 10.675f, 6.65f)
                    lineTo(11.025f, 4.0f)
                    horizontalLineTo(13.0f)
                    lineTo(13.325f, 6.65f)
                    curveTo(13.8417f, 6.7833f, 14.3208f, 6.9792f, 14.7625f, 7.2375f)
                    curveTo(15.2042f, 7.4958f, 15.6083f, 7.8167f, 15.975f, 8.2f)
                    lineTo(18.45f, 7.15f)
                    lineTo(19.425f, 8.85f)
                    lineTo(17.275f, 10.475f)
                    curveTo(17.3583f, 10.7083f, 17.4167f, 10.9542f, 17.45f, 11.2125f)
                    curveTo(17.4833f, 11.4708f, 17.5f, 11.7333f, 17.5f, 12.0f)
                    curveTo(17.5f, 12.2667f, 17.4833f, 12.5292f, 17.45f, 12.7875f)
                    curveTo(17.4167f, 13.0458f, 17.3583f, 13.2917f, 17.275f, 13.525f)
                    lineTo(19.425f, 15.15f)
                    lineTo(18.45f, 16.85f)
                    lineTo(15.975f, 15.825f)
                    curveTo(15.6083f, 16.1917f, 15.2042f, 16.5042f, 14.7625f, 16.7625f)
                    curveTo(14.3208f, 17.0208f, 13.8417f, 17.2167f, 13.325f, 17.35f)
                    lineTo(12.975f, 20.0f)
                    close()
                    moveTo(14.525f, 14.475f)
                    curveTo(13.8417f, 15.1583f, 13.0167f, 15.5f, 12.05f, 15.5f)
                    curveTo(11.0667f, 15.5f, 10.2375f, 15.1583f, 9.5625f, 14.475f)
                    curveTo(8.8875f, 13.7917f, 8.55f, 12.9667f, 8.55f, 12.0f)
                    curveTo(8.55f, 11.0333f, 8.8875f, 10.2083f, 9.5625f, 9.525f)
                    curveTo(10.2375f, 8.8417f, 11.0667f, 8.5f, 12.05f, 8.5f)
                    curveTo(13.0167f, 8.5f, 13.8417f, 8.8417f, 14.525f, 9.525f)
                    curveTo(15.2083f, 10.2083f, 15.55f, 11.0333f, 15.55f, 12.0f)
                    curveTo(15.55f, 12.9667f, 15.2083f, 13.7917f, 14.525f, 14.475f)
                    close()
                    moveTo(12.0f, 14.1395f)
                    curveTo(13.1816f, 14.1395f, 14.1395f, 13.1816f, 14.1395f, 12.0f)
                    curveTo(14.1395f, 10.8184f, 13.1816f, 9.8605f, 12.0f, 9.8605f)
                    curveTo(10.8184f, 9.8605f, 9.8605f, 10.8184f, 9.8605f, 12.0f)
                    curveTo(9.8605f, 13.1816f, 10.8184f, 14.1395f, 12.0f, 14.1395f)
                    close()
                }
            }
        }
        .build()
        return _settings!!
    }

private var _settings: ImageVector? = null
