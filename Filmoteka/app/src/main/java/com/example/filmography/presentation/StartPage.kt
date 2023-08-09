package com.example.filmography.presentation

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.filmography.presentation.ui.*

@Composable
fun StartPage(){
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

           ){
               Spacer(modifier = Modifier
                   .fillMaxHeight(.3f))
               Column(
                   modifier = Modifier
                       .fillMaxWidth(.8f)
                       .background(
                           color = Color.White.copy(alpha = .4f),
                           shape = RoundedCornerShape(20.dp)
                       )
                   ,
                   horizontalAlignment = Alignment.CenterHorizontally
               ){
                   Text(text = "Добро пожаловать!",
                       style= welcomeText,
                       modifier = Modifier
                           .padding(top = 20.dp,
                               bottom = 25.dp))
                   OutlinedButton(
                       colors = ButtonDefaults.buttonColors(
                           backgroundColor = Teal400),
                       modifier = Modifier
                           .fillMaxWidth(.8f),
                       border = BorderStroke(
                           width = 1.dp,
                           color = Color.White),
                       onClick = { /*TODO*/ })
                   {
                       Text(text = "Войти",
                           color = Color.White)
                   }
                   OutlinedButton(
                       colors = ButtonDefaults.buttonColors(
                           backgroundColor = Teal400),
                       modifier = Modifier
                           .fillMaxWidth(.8f),
                       border =  BorderStroke(
                           width = 1.dp,
                           color = Color.White),
                       onClick = { /*TODO*/ })
                   {
                       Text(text = "Зарегистрироваться",
                           color = Color.White)
                   }
               }
           }

}