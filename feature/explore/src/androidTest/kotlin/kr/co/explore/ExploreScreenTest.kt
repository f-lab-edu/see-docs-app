package kr.co.explore

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import kr.co.model.ExploreUiIntent
import kr.co.model.ExploreUiState
import kr.co.model.FileInfo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class ExploreScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()
    private val fakeUiState: MutableState<ExploreUiState> =
        mutableStateOf(ExploreUiState.INIT)

    private val fakeHandleIntent: MutableState<(ExploreUiIntent) -> Unit> =
        mutableStateOf({})

    @Before
    fun setup() {
        composeTestRule.setContent {
            ExploreScreen(
                state = fakeUiState.value,
                padding = PaddingValues(),
                handleIntent = fakeHandleIntent.value
            )
        }
    }

    @Test
    fun given_path_when_init_then_show_path() {
        fakeUiState.value = ExploreUiState.INIT.copy(path = "/local/storage")

        composeTestRule
            .onNode(hasText("> /local/storage"))
            .assertExists()
    }

    @Test
    fun when_state_contains_files_then_show_files() {
        fakeUiState.value = ExploreUiState(
            path = "/local/storage",
            folders = folders,
            files = files,
        )

        composeTestRule
            .onNodeWithText("Documents")
            .assertExists()
        composeTestRule
            .onNodeWithText("Downloads")
            .assertExists()
        composeTestRule
            .onNodeWithText("File1.pdf")
            .assertExists()
    }

    @Test
    fun when_file_click_then_handle_intent() {
        var clickedFile: FileInfo? = null

        fakeUiState.value = ExploreUiState(
            path = "/local/storage",
            folders = emptyList(),
            files = files
        )

        fakeHandleIntent.value = { intent ->
            if (intent is ExploreUiIntent.ClickFile) {
                clickedFile = intent.file
            }
        }

        composeTestRule
            .onNodeWithText("File1.pdf")
            .performClick()

        assertEquals(clickedFile, files.first())
    }

    companion object {
        private val folders = listOf(
            FileInfo.INIT.copy(
                name = "Documents",
                path = "/local/storage",
                isDirectory = true,
            ),
            FileInfo.INIT.copy(
                name = "Downloads",
                path = "/local/storage",
                isDirectory = true,
            )
        )

        private val files = listOf(
            FileInfo.INIT.copy(
                name = "File1.pdf",
                path = "/local/storage",
            )
        )
    }
}