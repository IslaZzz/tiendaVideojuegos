package islas.abril.tiendavideojuegos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    elevation = CardDefaults.cardElevation(6.dp)
                ) {

                    Column {
                        Image(
                            painter = painterResource(id = juego.imagen),
                            contentDescription = juego.nombre,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(180.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column(modifier = Modifier.padding(12.dp)) {


                            Text(
                                text = juego.nombre,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(4.dp))


                            Text(
                                text = "$${juego.precio}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
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