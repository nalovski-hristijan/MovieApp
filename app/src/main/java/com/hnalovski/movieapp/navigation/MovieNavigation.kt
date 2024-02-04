package com.hnalovski.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hnalovski.movieapp.screens.home.home.HomeScreen
import com.hnalovski.movieapp.screens.home.details.DetailsScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name) {
        composable(route = MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }

        composable(route = MovieScreens.DetailsScreen.name) {
            DetailsScreen(navController = navController)
        }
    }
}