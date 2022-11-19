package com.example.gym_app

import android.os.Bundle
import android.text.LoginFilter
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gym_app.ui.theme.Gym_appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Gym_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Login()
                }
            }
        }
    }
}
@Composable
fun Login() {
    var Username by remember{
        mutableStateOf("Username")
    }
    var Password by remember{
        mutableStateOf("Password")
    }
    Box(Modifier.background(color = Color.LightGray)){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 420.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(value = Username,
                onValueChange = { newValue -> Username = newValue },
                shape = CircleShape,
                leadingIcon = { Icon(imageVector = Icons.Filled.Face, contentDescription = "Username")}
            )

            TextField(value = Password,
                onValueChange = { Password = it },
                shape= CircleShape,
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Password")},
                visualTransformation =PasswordVisualTransformation()
            )

            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth(0.5f), shape = RoundedCornerShape(7.dp)) {
                Text(text = "SIGN IN")
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Gym_appTheme {
        Login()
    }
}