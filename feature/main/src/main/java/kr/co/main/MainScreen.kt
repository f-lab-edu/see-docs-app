package kr.co.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.co.main.navigation.MainNavHost
import kr.co.main.navigation.MainNavigator
import kr.co.main.navigation.MainTab
import kr.co.main.navigation.rememberMainNavigator
import kr.co.ui.theme.Theme

@Composable
fun Main() {
    val navigator = rememberMainNavigator()

    MainScreen(
        navigator = navigator,
    )
}

@Composable
private fun MainScreen(
    navigator: MainNavigator,
) {
    Scaffold(
        bottomBar = {
            MainBottomBar(
                visible = navigator.bottomBarVisible(),
                tabs = MainTab.entries,
                currentTab = navigator.currentTab(),
                onTabSelected = { tab ->
                    navigator.navigate(tab)
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.bg),
            content = {
                MainNavHost(
                    navigator = navigator,
                    padding = padding,
                )
            }
        )
    }
}