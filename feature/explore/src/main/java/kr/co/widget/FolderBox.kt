package kr.co.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.ui.icon.SeeDocsIcon
import kr.co.ui.icon.seedocsicon.Folder
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme

@Composable
internal fun FolderBox(
    name: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable(onClick = onClick)
            .border(
                width = 1.dp,
                color = Theme.colors.grayText,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(
                imageVector = SeeDocsIcon.Folder,
                contentDescription = "폴더",
                tint = Theme.colors.grayText,
            )

            Text(
                text = name,
                style = Theme.typography.body2r,
                color = Theme.colors.text
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            FolderBox(
                name = "Download",
                modifier = Modifier
            )
        }
    }
}