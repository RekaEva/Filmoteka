package com.example.filmography.feature.movielist.presentation.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImage
import com.example.filmography.R
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import java.net.ConnectException
import java.net.UnknownHostException

@Composable
fun MovieListScreen(
    mlViewModel: MovieListViewModel
) {
    val data = mlViewModel.getMovieListPaging().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { mlViewModel.backToLoginScreen() }) {
                        Row {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                            Icon(Icons.Filled.AccountBox, contentDescription = "User")
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Box(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            when (data.loadState.refresh) {
                is LoadState.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                    {
                        CircularProgressIndicator()
                    }
                }

                is LoadState.Error -> {
                    val errorState = data.loadState.refresh as LoadState.Error
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .padding(bottom = 10.dp)
                            .wrapContentSize(Alignment.Center)
                    ) {
                        Text(
                            text = errorMessage(errorState.error),
                            style = MaterialTheme.typography.body2,
                            textAlign = TextAlign.Center
                        )
                        OutlinedButton(
                            onClick = { data.retry() },
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 20.dp)
                        ) {
                            Text(
                                text = stringResource(R.string.update_button),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
//                    }
                }

                is LoadState.NotLoading -> {
                    LazyColumn {
                        items(data) { movie ->
                            Card(
                                modifier = Modifier
                                    .padding(10.dp)
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .clickable {
                                        if (movie != null) {
                                            mlViewModel.showDetailsButton(movie.id)
                                        }
                                    },
                                shape = MaterialTheme.shapes.medium,
                                elevation = 5.dp,
                                backgroundColor = MaterialTheme.colors.surface
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                ) {
                                    if (movie != null) {
                                        AsyncImage(
                                            model = movie.poster.previewUrl,
                                            contentDescription = null,
                                            modifier = Modifier
                                                .size(130.dp)
                                                .padding(8.dp),
                                            contentScale = ContentScale.Fit,
                                        )
                                        Column(Modifier.padding(8.dp)) {
                                            if (movie.name != null) {
                                                Text(
                                                    text = movie.name,
                                                    style = MaterialTheme.typography.h6,
                                                    modifier = Modifier
                                                        .padding(bottom = 8.dp)
                                                        .fillMaxWidth(),
                                                    color = MaterialTheme.colors.onSurface,
                                                )
                                            }
                                            CustomText(text = movie.year.toString())
                                            if (movie.shortDescription != null) {
                                                CustomText(text = movie.shortDescription)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun errorMessage(errorMessage: Throwable): String {
    return when (errorMessage) {
        is UnknownHostException, is ConnectException ->
            stringResource(R.string.internet_connection_error)

        else -> errorMessage.toString()
    }
}

@Composable
fun CustomText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(bottom = 4.dp)
    )
}
