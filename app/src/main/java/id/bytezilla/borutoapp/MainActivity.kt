package id.bytezilla.borutoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import id.bytezilla.borutoapp.navigation.SetupNavGraph
import id.bytezilla.borutoapp.ui.theme.BorutoAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BorutoAppTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}