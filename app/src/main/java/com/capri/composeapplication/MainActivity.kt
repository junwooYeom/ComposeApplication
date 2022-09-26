package com.capri.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.capri.composeapplication.ui.theme.ComposeApplicationTheme
import com.junwooyeom.composeapplication.domain.Movie
import com.junwooyeom.composeapplication.uicomponents.ListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
                MovieListItem()
            }
        }
    }
}

@Composable
fun MovieListItem() {
    val movieFlow: MainViewModel = viewModel()
    val movieData = movieFlow.movieListFlow.collectAsState()
    LazyColumn {
        itemsIndexed(
            movieData.value
        ) { _: Int, item: Movie ->
            ListItem(title = item.title, description = item.description, score = item.score)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        items(10) { index ->
            ListItem(title = "title : $index", description = "description : $index", score = "score: ${index.toFloat()}")
            Divider()
        }
    }
}
