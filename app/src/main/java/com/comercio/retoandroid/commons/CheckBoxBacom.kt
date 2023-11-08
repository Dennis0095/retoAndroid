package com.comercio.retoandroid.commons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.comercio.retoandroid.R

@Composable
fun CheckBoxBacom(
    clickCheck: () -> Unit,
    isChecked: Boolean
) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .clickable {
                    clickCheck.invoke()
                }
        ) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { },
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.CenterVertically)
            )

            Text(
                text = stringResource(id = R.string.rememberEmail),
                modifier = Modifier
                    .padding(8.dp)
                    .alignByBaseline()
                    .align(Alignment.CenterVertically),
            )
        }
}

@Preview(showBackground = true)
@Composable
fun GreetingScreenPreview() {
    CheckBoxBacom(isChecked = true, clickCheck = {

    })
}