package kr.co.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kr.co.main.navigation.MainNavHost
import kr.co.main.navigation.MainNavigator
import kr.co.main.navigation.MainTab
import kr.co.main.navigation.rememberMainNavigator
import kr.co.ui.icon.SeeDocsIcon
import kr.co.ui.icon.seedocsicon.Search
import kr.co.ui.icon.seedocsicon.Settings
import kr.co.ui.theme.SeeDocsTheme
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
        topBar = {
            MainTopBar(
                navigator.bottomBarVisible()
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier.navigationBarsPadding(),
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopBar(
    visible: Boolean,
    onSearchClick: () -> Unit = {},
    onSettingClick: () -> Unit = {},
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, -it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, -it.height) }
    ) {
        Column {
            TopAppBar(
                title = {
                    Text(
                        text = buildAnnotatedString {
                            append("See")
                            withStyle(
                                Theme.typography.title1sb.copy(color = Theme.colors.highlight)
                                    .toSpanStyle()
                            ) {
                                append("Docs")
                            }
                        },
                        style = Theme.typography.title1sb,
                    )
                },
                actions = {
                    Row(
                        modifier = Modifier.padding(end = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = SeeDocsIcon.Search,
                            contentDescription = "파일 검색",
                            tint = Theme.colors.icon
                        )

                        Icon(
                            modifier = Modifier.size(24.dp),
                            imageVector = SeeDocsIcon.Settings,
                            contentDescription = "설정",
                            tint = Theme.colors.icon
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Theme.colors.bg
                )
            )
            HorizontalDivider(
                thickness = 1.dp,
                color = Theme.colors.stroke
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        MainTopBar(true)
    }
}