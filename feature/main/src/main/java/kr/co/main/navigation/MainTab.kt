package kr.co.main.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import kr.co.navigation.MainNavigation
import kr.co.ui.icon.SeeDocsIcon
import kr.co.ui.icon.seedocsicon.*

internal enum class MainTab(
    val icon: ImageVector,
    val contentDescription: String,
    val route: MainNavigation,
) {
    Explore(
        icon = SeeDocsIcon.Explore,
        contentDescription = "Explore",
        route = MainNavigation.Explore,
    ),
    Recent(
        icon = SeeDocsIcon.RecentFill,
        contentDescription = "Recent",
        route = MainNavigation.Recent,
    ),
    Bookmark(
        icon = SeeDocsIcon.StarFill,
        contentDescription = "Bookmark",
        route = MainNavigation.Bookmark,
    ),
    ;

}