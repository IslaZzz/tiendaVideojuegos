package islas.abril.tiendavideojuegos.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import islas.abril.tiendavideojuegos.R
import islas.abril.tiendavideojuegos.dummies.obtenerVideojuegoRandom
import islas.abril.tiendavideojuegos.model.Videojuego


@Preview (showBackground = true)
@Composable
fun showVideogameDetail(){
    videogameDetail(obtenerVideojuegoRandom())
}

@Composable
fun videogameDetail(videojuego: Videojuego){

    Column(modifier = Modifier.fillMaxSize()){
        Row(modifier = Modifier.padding(top=50.dp, start=25.dp)){
            Text(videojuego.nombre,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Column(modifier = Modifier.padding(20.dp)) {
            Image(
                painter = painterResource(videojuego.imagen),
                contentDescription = "Portada de ${videojuego.nombre}",

            )

            }
        }
    }
