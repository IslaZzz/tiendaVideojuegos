package islas.abril.tiendavideojuegos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment

@Composable
fun CatalogVideoGames(
    innerPadding: PaddingValues,
    viewModel: GamesViewModel = viewModel()
) {

    Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1E1E2E),
                            Color(0xFF2A2A40)
                        )
                    )
                )
                .padding(innerPadding)
                .padding(16.dp)

    )
    {

        Text(
            text = "Catálogo de videojuegos",
            style = MaterialTheme.typography.headlineMedium,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )


        Spacer(modifier = Modifier.height(16.dp))

        if (viewModel.juegoSeleccionado == null) {

            LazyColumn {

                items(viewModel.listaJuegos) { juego ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        shape = RoundedCornerShape(16.dp),
                        elevation = CardDefaults.cardElevation(8.dp),
                        onClick = {
                            viewModel.seleccionarJuego(juego)
                        }
                    ) {

                        Box {

                            Image(
                                painter = painterResource(id = juego.imagen),
                                contentDescription = juego.nombre,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(200.dp),
                                contentScale = ContentScale.Crop
                            )

                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .background(
                                        Brush.verticalGradient(
                                            colors = listOf(
                                                Color.Transparent,
                                                Color.Black.copy(alpha = 0.7f)
                                            )
                                        )
                                    )
                            )

                            Column(
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(12.dp)
                            ) {

                                Text(
                                    text = juego.nombre,
                                    color = Color.White,
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )

                                Spacer(modifier = Modifier.height(4.dp))

                                Text(
                                    text = "$${juego.precio}",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier
                                        .background(
                                            Brush.horizontalGradient(
                                                listOf(Color(0xFF00C853), Color(0xFF64DD17))
                                            ),
                                            shape = RoundedCornerShape(50)
                                        )
                                        .padding(horizontal = 10.dp, vertical = 4.dp)
                                )
                            }
                        }
                    }
                }
            }

        } else {

            videogameDetail(viewModel.juegoSeleccionado!!)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun CatalogVideoGamesPreview(){
    CatalogVideoGames(PaddingValues(5.dp))
}