package kr.co.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

private val White = Color(0xFFFFFFFF)
private val Black = Color(0xFF1B1C1E)

private val Gray1 = Color(0xFFF8F8F8)
private val Gray2 = Color(0xFFEEEEEE)
private val Gray3 = Color(0xFFDADADA)
private val Gray4 = Color(0xFFB5B5B5)
private val Gray5 = Color(0xFF909090)
private val Gray6 = Color(0xFF6B6B6B)
private val Gray7 = Color(0xFF464646)

private val Blue1 = Color(0xFF007AFF)
private val Blue2 = Color(0xFF6877FF)
private val Blue3 = Color(0xFF8E99FF)
private val Blue4 = Color(0xFFB3BBFF)
private val Blue5 = Color(0xFFD9DDFF)
private val Blue6 = Color(0xFFEDEEFF)

@Immutable
data class SeeDocsColors(
    val material: ColorScheme,
    val bg: Color,
    val text: Color,
    val highlight: Color,
    val icon: Color,
    val stroke: Color,
    val bottomIcon: Color,
    val grayText: Color,
)

internal val LightColors = SeeDocsColors(
    material = lightColorScheme(),
    bg = White,
    text = Black,
    highlight = Blue1,
    icon = Black,
    stroke = Gray2,
    bottomIcon = Gray2,
    grayText = Gray4,
)

internal val DarkColors = SeeDocsColors(
    material = darkColorScheme(),
    bg = Gray7,
    text = Gray1,
    highlight = Blue2,
    icon = Gray1,
    stroke = Gray5,
    bottomIcon = Gray5,
    grayText = Gray4,
)

internal val LocalColors = compositionLocalOf { LightColors }