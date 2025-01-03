package kr.co.main.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import kr.co.navigation.MainNavigation
import kr.co.navigation.Route
import kr.co.navigation.bookmarkNavGraph
import kr.co.navigation.exploreNavGraph
import kr.co.navigation.pdfNavGraph
import kr.co.navigation.recentNavGraph

@Composable
internal fun MainNavHost(
    navigator: MainNavigator,
    padding: PaddingValues
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
    ) {
        exploreNavGraph(
            padding = padding,
            navigateToFolder = { navigator.navigate(MainNavigation.Explore(it)) },
            navigateToPdf = { navigator.navigate(Route.Pdf(it)) }
        )

        recentNavGraph(
            padding = padding
        )

        bookmarkNavGraph(
            padding = padding
        )

        pdfNavGraph(
            popBackStack = navigator::popBackStack
        )
    }
}
