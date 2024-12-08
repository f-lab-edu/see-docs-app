package kr.co.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data class View(val channel: String) : Route

    @Serializable
    data object Pdf : Route
}

sealed interface MainNavigation {

    @Serializable
    data object Explore : MainNavigation

    @Serializable
    data object Recent : MainNavigation

    @Serializable
    data object Bookmark : MainNavigation

}