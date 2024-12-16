package kr.co.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kr.co.pdf.PdfRoute

fun NavGraphBuilder.pdfNavGraph(
    popBackStack: () -> Unit = {}
) {
    composable<Route.Pdf> {
        PdfRoute(
            popBackStack = popBackStack
        )
    }
}