package kr.co.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

object Theme {
    val colors: SeeDocsColors
        @Composable
        get() = LocalColors.current

    val typography: SeeDocsTypography
        @Composable
        get() = LocalTypography.current
}

@Composable
fun SeeDocsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    CompositionLocalProvider(
        LocalColors provides if (darkTheme) DarkColors else LightColors,
        LocalTypography provides SeeDocsTypography()
    ) {
        MaterialTheme(
            colorScheme = LocalColors.current.material,
            content = content
        )
    }
}