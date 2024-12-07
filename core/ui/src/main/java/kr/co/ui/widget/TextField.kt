package kr.co.ui.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.co.ui.theme.SeeDocsTheme
import kr.co.ui.theme.Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTextField(
    value: String,
    onValueChange: (String) -> Unit,
    hint: String? = null,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }

    BasicTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        textStyle = Theme.typography.body1r.copy(color = Theme.colors.text),
        singleLine = true
    ) {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Theme.colors.stroke,
                    shape = RoundedCornerShape(8.dp)
                ),
            contentAlignment = Alignment.CenterStart
        ) {
            TextFieldDefaults.DecorationBox(
                value = value,
                innerTextField = { it() },
                enabled = true,
                singleLine = true,
                visualTransformation = VisualTransformation.None,
                interactionSource = interactionSource,
                placeholder = {
                    hint?.let {
                        Text(
                            text = it,
                            color = Theme.colors.grayText,
                            style = Theme.typography.body1r
                        )
                    }
                },
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Transparent,
                ),
                contentPadding = PaddingValues(
                    horizontal = 12.dp,
                    vertical = 4.dp
                )
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    SeeDocsTheme {
        SimpleTextField(
            value = "34",
            onValueChange = {},
            hint = "hint"
        )
    }
}