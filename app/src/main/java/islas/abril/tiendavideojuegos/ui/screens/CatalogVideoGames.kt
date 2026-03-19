package islas.abril.tiendavideojuegos.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import islas.abril.tiendavideojuegos.viewmodel.GamesViewModel

@Composable
fun CatalogVideoGames(
    innerPadding: PaddingValues,
    viewModel: GamesViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text("Catálogo de videojuegos")

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(viewModel.listaJuegos) { juego ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {

                        Text(juego.nombre)

                        Spacer(modifier = Modifier.height(4.dp))

                        Text("$${juego.precio}")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CatalogVideoGamesPreview(){
    CatalogVideoGames(PaddingValues(5.dp))
}