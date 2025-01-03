package kr.co.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kr.co.pdf.PdfRoute

fun NavGraphBuilder.pdfNavGraph(
    popBackStack: () -> Unit = {}
) {
    composable<Route.Pdf> {
        PdfRoute(
            path = it.toRoute<Route.Pdf>().path,
            popBackStack = popBackStack
        )
    }
}