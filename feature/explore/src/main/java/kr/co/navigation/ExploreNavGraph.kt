package kr.co.navigation

import android.os.Environment
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kr.co.explore.ExploreRoute

fun NavGraphBuilder.exploreNavGraph(
    padding: PaddingValues,
    navigateToFolder: (String) -> Unit = {},
    navigateToPdf: (String) -> Unit = {}
) {
    composable<MainNavigation.Explore> {
        ExploreRoute(
            path = it.toRoute<MainNavigation.Explore>().path?: Environment.getExternalStorageDirectory().absolutePath,
            padding = padding,
            navigateToFolder = navigateToFolder,
            navigateToPdf = navigateToPdf
        )
    }
}