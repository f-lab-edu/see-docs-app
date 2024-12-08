package kr.co.navigation

import kotlinx.serialization.Serializable

sealed interface Route {

    @Serializable
    data class View(val channel: String) : Route

    @Serializable
    data class Pdf(val path: String) : Route
}

sealed interface MainNavigation {

    @Serializable
    data class Explore(val path: String? = null) : MainNavigation

    @Serializable
    data object Recent : MainNavigation

    @Serializable
    data object Bookmark : MainNavigation

}