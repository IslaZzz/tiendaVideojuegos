package islas.abril.tiendavideojuegos.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import islas.abril.tiendavideojuegos.ui.screens.*
import islas.abril.tiendavideojuegos.viewmodel.GamesViewModel

@Composable
fun AppNavigation() {

    val navController = rememberNavController()
    val viewModel: GamesViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = Routes.CATALOGO
    ) {
        composable(Routes.CATALOGO) {
            CatalogVideoGames(PaddingValues(0.dp), navController,viewModel)
        }
        composable("${Routes.DETALLE}/{id}") { backStackEntry ->

            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
            val juego = id?.let { viewModel.obtenerJuegoID(it) }

            if (juego != null) {
                videogameDetail(juego, navController, viewModel)
            } else {
                navController.popBackStack()
            }
        }
    }
}