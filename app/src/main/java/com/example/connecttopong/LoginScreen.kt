package com.example.connecttopong

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

enum class LoginNav(){
    Start,
    ForgotPassword,
    Register,
    Login
}

@Composable
private fun LoginScreen(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = LoginNav.Start.name,
        modifier = Modifier
    ){
        composable(route = LoginNav.Start.name){
            Login (onClickLogin = { navController.navigate(LoginNav.Register.name)} )
        }
        composable(route = LoginNav.ForgotPassword.name){
            ForgotPassword(onClickRecover = { navController.navigate(LoginNav.Start.name)})
        }
        composable(route = LoginNav.Register.name){
            Register(onClickCreate = { navController.navigate(LoginNav.ForgotPassword.name)})
        }
    }
}


@Composable
fun ForgotPassword(modifier: Modifier = Modifier, onClickRecover: () -> Unit){
    var usernameText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }

    Column() {
        OutlinedTextField(
            value = usernameText,
            onValueChange = { usernameText = it },
            label = { Text("Username") }
        )

        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("password") }
        )
        OutlinedButton(onClick = onClickRecover) {
            Text(text = "Cancel")
        }
        Button(
            onClick =  onClickRecover) {
            Text(text = "Recover")

        }
    }
}

@Composable
fun Register(modifier: Modifier = Modifier, onClickCreate: () -> Unit) {
    var usernameText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }
    var repeatPasswordText by rememberSaveable { mutableStateOf("") }
    var emailText by rememberSaveable { mutableStateOf("") }

    Column() {
        OutlinedTextField(
            value = usernameText,
            onValueChange = { usernameText = it },
            label = { Text("Username") }
        )
        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("password") }
        )
        OutlinedTextField(
            value = repeatPasswordText,
            onValueChange = { repeatPasswordText = it },
            label = { Text("repeat password") }
        )
        OutlinedTextField(
            value = emailText,
            onValueChange = { emailText = it },
            label = { Text("Enter Email") }
        )
        OutlinedButton(onClick = onClickCreate) {
            Text(text = "Cancel")
        }
        Button(
            onClick =  onClickCreate) {
            Text(text = "Create")

        }
    }
}

@Composable
fun Login(modifier: Modifier = Modifier, onClickLogin: () -> Unit){
    var usernameText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }

    Column() {
        OutlinedTextField(
            value = usernameText,
            onValueChange = { usernameText = it },
            label = { Text("Username") }
        )

        OutlinedTextField(
            value = passwordText,
            onValueChange = { passwordText = it },
            label = { Text("password") }
        )
        TextButton(onClick = onClickLogin) {
            Text(text = "Forgot Password")
        }
        OutlinedButton(onClick = { /*TODO*/ }) {
            Text(text = "Create user")
        }
        Button(
            onClick =  onClickLogin) {
            Text(text = "Login")

        }
    }
}
