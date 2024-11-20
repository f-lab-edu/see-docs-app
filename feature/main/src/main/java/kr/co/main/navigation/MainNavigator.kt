package kr.co.main.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kr.co.navigation.MainNavigation
import kr.co.navigation.Route

internal class MainNavigator(
    val navController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val startDestination: MainNavigation = MainNavigation.Explore

    @Composable
    fun currentTab(): MainTab? =
        MainTab.entries.find {
            currentDestination?.hasRoute(it.route::class) == true
        }

    fun navigate(tab: MainTab) {
        navController.navigate(tab.route) {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    @Composable
    fun bottomBarVisible(): Boolean = MainTab.entries.any {
        currentDestination?.hasRoute(it.route::class) == true
    }

    fun navigate(route: Route, navOptions: NavOptions) {
        navController.navigate(route, navOptions)
    }

    fun popBackStack() {
        navController.popBackStack()
    }
}

@Composable
internal fun rememberMainNavigator(
    navController: NavHostController = rememberNavController(),
): MainNavigator = remember(navController) {
    MainNavigator(navController)
}