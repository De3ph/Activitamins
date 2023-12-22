package com.example.activitamins.presentation.mainActivity

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.activitamins.presentation.components.layout.BottomBar
import com.example.activitamins.presentation.components.layout.TopBar
import com.example.activitamins.presentation.navigation.NavGraph
import com.example.activitamins.presentation.navigation.Screens
import com.example.activitamins.ui.theme.AppTheme
import com.example.activitamins.viewModel.ActivitiesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavController

    // ViewModel injection
    // viewModels() activity den geldiğinden sadece activity scope'unda kullanılabilir
    private val activitiesViewModel: ActivitiesViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navController = rememberNavController()

            Main(
                navController = navController
            ) {
                NavGraph(
                    ctx = this@MainActivity,
                    navController = navController,
                    activitiesViewModel = activitiesViewModel
                )
            }

        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main(
    navController: NavController,
    content: @Composable () -> Unit
) {
    AppTheme {
        // A surface container using the 'background' color from the theme
        Scaffold(
            topBar = {
                TopBar(navController = navController, title = "Activitamins")
            },
            bottomBar = {
                BottomBar(navController)
            }
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(
                        it
                    ),
            ) {
                content()
            }
        }
    }
}
