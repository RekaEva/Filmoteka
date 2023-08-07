package com.example.filmography.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment

class AutenticationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                AuthScreen()
            }
        }
    }
}


@Preview
@Composable
fun AuthScreen()
{
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)
        .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(text = "Авторизация",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(value = login, onValueChange = {login = it  }, //newLogin -> login = newLogin
            label = { Text ("Введите логин") },
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = "person") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp)
        )

        OutlinedTextField(value = password, onValueChange = { password = it },
            label = { Text ("Веедите пароль") },
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(onClick = { logged(login, password) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp))
        {
            Text(text = "Login",
                textAlign = TextAlign.Center)
        }

    }
}

fun logged(login : String, password : String)
{
    // тут логика в случает успешной и неуспешной автоирзации
}

//@Preview
//@Composable
//fun AuthScreen()
//{
//       Column( modifier = Modifier
//           .fillMaxSize()
//           .background(color = Color.White),
//           horizontalAlignment = Alignment.CenterHorizontally,
//           verticalArrangement = Arrangement.Center
//       ) {
//           Text(text = "Авторизация", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           Text(text = "Введите логин:", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           TextField(value = "Login", onValueChange = {})
//           Text(text = "Введите пароль:", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           TextField(value = "Password", onValueChange = {})
//           Button(onClick = {/*TODO*/}, modifier = Modifier.padding(15.dp))
//           {
//               Text(text = "Войти",modifier = Modifier.padding(8.dp))
//           }
//
//       }
//}
//@Preview
//@Composable
//fun AuthScreen()
//{
//       Column( modifier = Modifier
//           .fillMaxSize()
//           .background(color = Color.White),
//           horizontalAlignment = Alignment.CenterHorizontally,
//           verticalArrangement = Arrangement.Center
//       ) {
//           Text(text = "Авторизация", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           Text(text = "Введите логин:", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           TextField(value = "Login", onValueChange = {})
//           Text(text = "Введите пароль:", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
//           TextField(value = "Password", onValueChange = {})
//           Button(onClick = {/*TODO*/}, modifier = Modifier.padding(15.dp))
//           {
//               Text(text = "Войти",modifier = Modifier.padding(8.dp))
//           }
//
//       }
//}
