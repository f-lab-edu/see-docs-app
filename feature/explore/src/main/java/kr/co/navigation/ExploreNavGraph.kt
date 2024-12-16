package kr.co.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.co.explore.ExploreRoute

fun NavGraphBuilder.exploreNavGraph(
    padding: PaddingValues,
    navigateToPdf: () -> Unit = {}
) {
    composable<MainNavigation.Explore> {
        ExploreRoute(
            padding = padding,
            navigateToPdf = navigateToPdf
        )
    }
}