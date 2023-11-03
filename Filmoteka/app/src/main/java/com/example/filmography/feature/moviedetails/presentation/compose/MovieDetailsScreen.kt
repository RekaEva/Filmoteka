package com.example.filmography.feature.moviedetails.presentation.compose

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
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
import com.example.filmography.feature.moviedetails.presentation.model.MovieDetailsViewModel
import com.example.filmography.feature.movielist.presentation.compose.errorMessage


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MovieDetailsScreen(
    mdViewModel: MovieDetailsViewModel,
    movieId: Int
) {
    val uiState by mdViewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        mdViewModel.getMovieDetails(movieId)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = { mdViewModel.onBackButtonPressed() }) {
                        Row {
                            Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                        }
                    }
                }
            )
        }
    ) {
        if (uiState.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                )
            }
        } else if (uiState.movieDetails != null) {
            val movieDetail = uiState.movieDetails
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    shape = MaterialTheme.shapes.medium,
                    elevation = 5.dp,
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        AsyncImage(
                            model = movieDetail?.poster?.url,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(300.dp),
                            contentScale = ContentScale.Fit
                        )
                        movieDetail?.name?.let { name ->
                            Text(
                                text = name,
                                style = MaterialTheme.typography.h4,
                                modifier = Modifier.align(Alignment.CenterHorizontally)
                            )
                        }
                        movieDetail?.year?.let { year ->
                            CustomTextDetails(
                                text = stringResource(R.string.movieInfo_year)
                                        + year.toString()
                            )
                        }
                        movieDetail?.ageRating?.let { ageRating ->
                            CustomTextDetails(
                                text = stringResource(R.string.movieInfo_age_rating) +
                                        ageRating.toString()
                            )
                        }
                        movieDetail?.movieLength?.let { movieLength ->
                            CustomTextDetails(
                                text = stringResource(R.string.movieInfo_length)
                                        + movieLength
                            )
                        }
                        movieDetail?.slogan?.let { slogan ->
                            CustomTextDetails(text = slogan)
                        }
                        movieDetail?.description?.let { description ->
                            CustomTextDetails(text = description)
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
                        onClick = { mdViewModel.getMovieDetails(movieId) },
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
fun CustomTextDetails(text: String) {
    Spacer(modifier = Modifier.height(10.dp))
    Text(
        text = text,
        style = MaterialTheme.typography.body1
    )
}
