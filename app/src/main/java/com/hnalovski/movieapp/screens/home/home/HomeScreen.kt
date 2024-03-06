package com.hnalovski.movieapp.screens.home.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hnalovski.movieapp.model.Movie
import com.hnalovski.movieapp.model.getMovies
import com.hnalovski.movieapp.navigation.MovieScreens
import com.hnalovski.movieapp.widgets.MovieRow

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "Movies") },
            modifier = Modifier.shadow(5.dp),
            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.LightGray)
        )
    }) {
        MainContent(navController = navController)

    }
}

@Composable
fun MainContent(
    navController: NavController,
    movieList: List<Movie> = getMovies()
) {
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = movieList) {
                    MovieRow(movie = it) { movie ->
                        navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")

                    }

                }
            }
        }

    }
}