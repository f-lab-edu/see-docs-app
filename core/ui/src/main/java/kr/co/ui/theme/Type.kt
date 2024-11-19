package kr.co.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kr.co.seedocs.core.ui.R

private val pretendard = FontFamily(
    Font(R.font.pretendard_regular, weight = FontWeight.Normal),
    Font(R.font.pretendard_semibold, weight = FontWeight.SemiBold),
    Font(R.font.pretendard_bold, weight = FontWeight.Bold),
)

private val Title1SB = TextStyle(
    fontFamily = pretendard,
    fontWeight = FontWeight.SemiBold,
    fontSize = 24.sp,
    lineHeight = 32.sp,
)

private val Title2SB = Title1SB.copy(fontSize = 20.sp, lineHeight = 28.sp)

private val Body1SB = Title2SB.copy(fontSize = 16.sp, lineHeight = 24.sp)
private val Body1R = Body1SB.copy(fontWeight = FontWeight.Normal)
private val Body2SB = Body1SB.copy(fontSize = 14.sp, lineHeight = 20.sp)
private val Body2R = Body2SB.copy(fontWeight = FontWeight.Normal)
private val Caption1R = Body2R.copy(fontSize = 12.sp, lineHeight = 16.sp)

@Immutable
data class SeeDocsTypography(
    val title1sb: TextStyle = Title1SB,
    val title2sb: TextStyle = Title2SB,
    val body1sb: TextStyle = Body1SB,
    val body1r: TextStyle = Body1R,
    val body2sb: TextStyle = Body2SB,
    val body2r: TextStyle = Body2R,
    val caption1r: TextStyle = Caption1R,
)

internal val LocalTypography = staticCompositionLocalOf { SeeDocsTypography() }