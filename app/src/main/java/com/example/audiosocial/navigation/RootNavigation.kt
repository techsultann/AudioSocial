package com.example.audiosocial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.audiosocial.ui.presentation.authentication.LoginScreen
import com.example.audiosocial.ui.presentation.authentication.SignupScreen
import com.example.audiosocial.ui.presentation.home.HomeScreen

@Composable
fun RootNavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "signup"
    ){
        composable("signup"){
            SignupScreen(
                gotoSignIn = {
                    navController.navigate("login")
                }
            )
        }
        composable("login"){
            LoginScreen(
                gotoHomeScreen = { navController.navigate("homeScreen")},
                gotoSignup = {navController.navigate("signup")}
            )
        }
        composable("homeScreen"){
            HomeScreen()
        }
    }
}