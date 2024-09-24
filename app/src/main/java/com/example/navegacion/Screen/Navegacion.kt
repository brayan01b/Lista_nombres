package com.example.navegacion.Screen

import PersonasViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun navigationExample() {
    val navController = rememberNavController()
    val viewModel: PersonasViewModel = viewModel()  // ViewModel compartido

    NavHost(navController = navController, startDestination = "screen_a") {
        composable("screen_a") {
            ScreenA(navController, viewModel)
        }
        composable("screen_b") {
            ScreenB(navController, viewModel)
        }
    }
}
