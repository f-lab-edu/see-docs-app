package kr.co.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.co.bookmark.BookmarkRoute

fun NavGraphBuilder.bookmarkNavGraph(
    padding: PaddingValues
) {
    composable<MainNavigation.Bookmark> {
        BookmarkRoute(
            padding = padding,
        )
    }
}