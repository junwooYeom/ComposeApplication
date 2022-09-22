package com.junwooyeom.composeapplication.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

/**
 * {description}
 *
 * @author capri
 * @since 2022/09/22
 */

@Composable
fun ListItem(
    title: String,
    description: String,
    score: String,
) {
    Column {
        Text(text = title)
        Text(text = description)
        Text(text = score)
    }
}