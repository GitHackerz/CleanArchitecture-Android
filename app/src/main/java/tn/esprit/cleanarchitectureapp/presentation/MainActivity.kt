package tn.esprit.cleanarchitectureapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import tn.esprit.cleanarchitectureapp.navigation.Navigation
import tn.esprit.cleanarchitectureapp.ui.theme.CleanArchitectureAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CleanArchitectureAppTheme {
                Navigation()
            }
        }
    }
}


