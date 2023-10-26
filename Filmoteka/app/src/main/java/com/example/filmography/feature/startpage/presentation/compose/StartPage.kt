package com.example.filmography.feature.startpage.presentation.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.filmography.R
import com.example.filmography.feature.startpage.presentation.model.StartPageViewModel
import com.example.filmography.presentation.ui.Teal200
import com.example.filmography.presentation.ui.Teal400
import com.example.filmography.presentation.ui.welcomeText

@Composable
fun StartPage(startPageViewModel: StartPageViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Teal200,
                        Teal200.copy(alpha = .5f),
                        Teal200.copy(alpha = .5f),
                        Teal200
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Spacer(
            modifier = Modifier
                .fillMaxHeight(.3f)
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(.8f)
                .background(
                    color = Color.White.copy(
                        alpha = .4f
                    ),
                    shape = RoundedCornerShape(20.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.welcome_header),
                style = welcomeText,
                modifier = Modifier
                    .padding(
                        top = 20.dp,
                        bottom = 25.dp
                    )
            )
            CustomButton(
                text = stringResource(R.string.do_log_in),
                onClick = {
                    startPageViewModel.pressLogin()
                },
            )
            CustomButton(
                text = stringResource(R.string.do_sign_up),
                onClick = {
                    startPageViewModel.pressSignUp()
                }
            )

        }
    }
}

@Composable
fun CustomButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Teal400
        ),
        modifier = Modifier
            .fillMaxWidth(.8f),
        border = BorderStroke(
            width = 1.dp,
            color = Color.White
        ),
        onClick = onClick
    )
    {
        Text(
            text = text,
            color = Color.White
        )
    }
}