package kr.co.ui.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.ui.icon.SeeDocsIcon
import kr.co.ui.icon.seedocsicon.PDF
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun FileBox(
    name: String,
    dateTime: LocalDateTime,
    onFileClick: () -> Unit = {},
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onFileClick)
            .padding(
                vertical = 12.dp,
                horizontal = 8.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Icon(
            modifier = Modifier.size(32.dp),
            imageVector = SeeDocsIcon.PDF,
            contentDescription = "pdf",
            tint = Color.Unspecified
        )

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                modifier = Modifier,
                text = name,
                style = Theme.typography.body2sb,
                color = Theme.colors.text
            )
            Text(
                modifier = Modifier,
                text = dateTime.format(DateTimeFormatter.ofPattern("yyyy.MM.dd")),
                style = Theme.typography.caption1r,
                color = Theme.colors.grayText
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        FileBox("Effective Kotlin", LocalDateTime.now())
    }
}