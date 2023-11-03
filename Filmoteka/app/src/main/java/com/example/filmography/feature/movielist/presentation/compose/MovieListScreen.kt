package com.example.filmography.feature.movielist.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.filmography.R
import com.example.filmography.feature.movielist.presentation.model.MovieListViewModel
import java.net.ConnectException
import java.net.UnknownHostException

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieListScreen(
    mlViewModel: MovieListViewModel
) {
    val uiState by mlViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        mlViewModel.getMovieList()
    }

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
    ) {
        if (uiState.load) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                )
            }
        } else if (uiState.list.moviesList.isNotEmpty()) {
            LazyColumn {
                items(uiState.list.moviesList) { movie ->
                    Card(
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .clickable {
                                mlViewModel.showDetailsButton(movie.id)
                            },
                        shape = MaterialTheme.shapes.medium,
                        elevation = 5.dp,
                        backgroundColor = MaterialTheme.colors.surface
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
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
        } else {
            uiState.error?.let {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(bottom = 10.dp)
                        .wrapContentSize(Alignment.Center)
                ) {
                    Text(
                        text = errorMessage(it),
                        style = MaterialTheme.typography.body2,
                        textAlign = TextAlign.Center
                    )
                    OutlinedButton(
                        onClick = { mlViewModel.getMovieList() },
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
            }
        }
    }
}

@Composable
fun errorMessage(errorMessage: Exception): String {
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


