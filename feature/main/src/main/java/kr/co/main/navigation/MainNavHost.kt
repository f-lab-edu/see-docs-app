package kr.co.main.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost

@Composable
internal fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
    ) {

    }
}
