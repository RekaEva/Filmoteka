package com.example.filmography.presentation.view

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.example.filmography.R
import com.example.filmography.presentation.ui.headerTextStyle
import com.example.filmography.presentation.viewModel.registr

class RegictrationFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RegistrScreen()
            }
        }
    }
}

@Composable
fun  RegistrScreen() {
    var email by remember { mutableStateOf("") }
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var password2 by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.SignUpHeader),
            style = headerTextStyle,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.SetEmail)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    contentDescription = "email"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp,
                    top = 10.dp)
        )
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text(stringResource(R.string.SetLogin)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Person,
                    contentDescription = "person"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp,
                    top = 10.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.SetPassword)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 10.dp,
                    top = 10.dp
                ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        OutlinedTextField(
            value = password2,
            onValueChange = { password2 = it },
            label = { Text(stringResource(R.string.RepeatPassword)) },
            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    contentDescription = "password"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    bottom = 10.dp,
                    top = 10.dp
                ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            )
        )

        OutlinedButton(onClick = { registr(login, password, password2, context) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp,
                    top = 10.dp))
        {
            Text(text = stringResource(R.string.SignUpButton),
                textAlign = TextAlign.Center)
        }
    }
}

