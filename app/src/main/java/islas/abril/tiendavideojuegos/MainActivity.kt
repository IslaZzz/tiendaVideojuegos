package islas.abril.tiendavideojuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import islas.abril.tiendavideojuegos.navigation.AppNavigation
import islas.abril.tiendavideojuegos.ui.screens.CatalogVideoGames
import islas.abril.tiendavideojuegos.ui.theme.TiendaVideojuegosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            TiendaVideojuegosTheme {
                AppNavigation()
            }
        }
    }
}
