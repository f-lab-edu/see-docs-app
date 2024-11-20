package kr.co.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Icon
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kr.co.main.navigation.MainTab
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme

@Composable
internal fun MainBottomBar(
    visible: Boolean,
    tabs: List<MainTab>,
    currentTab: MainTab?,
    onTabSelected: (MainTab) -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(
                    color = Theme.colors.bg
                ),
        ) {
            VerticalDivider(
                thickness = 1.dp,
                color = Theme.colors.stroke
            )
            tabs.forEach { tab ->
                Item(
                    tab = tab,
                    selected = tab == currentTab,
                    onClick = { onTabSelected(tab) }
                )
            }
        }
    }
}

@Composable
private fun RowScope.Item(
    tab: MainTab,
    selected: Boolean,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .selectable(
                selected = selected,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = tab.icon,
            contentDescription = tab.contentDescription,
            tint = if (selected) Theme.colors.highlight else Theme.colors.bottomIcon,
        )
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        Box(
            modifier = Modifier
                .background(Theme.colors.highlight.copy(alpha = 0.2f))
                .padding(12.dp)
        ) {
            MainBottomBar(
                visible = true,
                tabs = MainTab.entries,
                currentTab = MainTab.Explore,
                onTabSelected = { tab -> },
            )
        }
    }
}