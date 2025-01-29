package kr.co.bookmark

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import kr.co.model.BookmarkUiIntent
import kr.co.model.BookmarkUiState
import kr.co.model.FileInfo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class BookmarkScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val uiState: MutableState<BookmarkUiState> = mutableStateOf(BookmarkUiState.INIT)

    private val handleIntent: MutableState<(BookmarkUiIntent) -> Unit> = mutableStateOf({})

    @Before
    fun setUp() {
        composeTestRule.setContent {
            BookmarkScreen(
                padding = PaddingValues(),
                state = uiState.value,
            )
        }
    }

    @Test
    fun when_init_then_show_bookmark_list() {
        uiState.value = BookmarkUiState(
            files = files
        )

        composeTestRule
            .onNodeWithText("bookmark1")
            .assertExists()

        composeTestRule
            .onNodeWithText("bookmark2")
            .assertExists()
    }

    @Test
    fun when_click_file_then_handle_intent() {
        uiState.value = BookmarkUiState(
            files = files
        )

        handleIntent.value = { intent ->
            if (intent is BookmarkUiIntent.ClickFile) {
                assertEquals(files.first(), intent.file)
            }
        }

        composeTestRule
            .onNodeWithText("bookmark1")
            .performClick()
    }

    companion object {
        private val files = listOf(
            FileInfo.INIT.copy(
                name = "bookmark1"
            ),
            FileInfo.INIT.copy(
                name = "bookmark2"
            )
        )
    }
}