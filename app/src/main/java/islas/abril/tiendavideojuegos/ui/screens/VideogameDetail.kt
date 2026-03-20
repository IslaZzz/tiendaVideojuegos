package islas.abril.tiendavideojuegos.ui.screens

import android.R.attr.shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.magnifier
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import islas.abril.tiendavideojuegos.R
import islas.abril.tiendavideojuegos.dummies.obtenerVideojuegoRandom
import islas.abril.tiendavideojuegos.model.Videojuego
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import islas.abril.tiendavideojuegos.viewmodel.GamesViewModel



//@Preview (showBackground = true)
//@Composable
//fun showVideogameDetail(){
//    videogameDetail(obtenerVideojuegoRandom())
//}

@Composable
fun videogameDetail(videojuego: Videojuego, navController: NavController, viewModel: GamesViewModel){

    val (precioFinal, descuento) = remember {
        viewModel.aplicarDescuento(videojuego.precio)
    }

    Column(modifier = Modifier.fillMaxSize()
        .background(
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF1E1E2E),
                Color(0xFF2A2A40)
            )
        )
    )
    ){
        Row(modifier = Modifier.padding(top=50.dp, start=25.dp)){
            Text(videojuego.nombre,
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Column(modifier = Modifier.padding(top=20.dp)) {
            Image(
                modifier = Modifier.size(290.dp,360.dp),
                painter = painterResource(videojuego.imagen),
                contentDescription = "Portada de ${videojuego.nombre}",
            )
            }
        Spacer(modifier = Modifier.padding(18.dp))

        Column(modifier = Modifier.fillMaxWidth().padding(start=20.dp,end=20.dp)) {
            Text(
                modifier = Modifier.padding(end=15.dp),
                text = "${videojuego.descripcion}",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Justify
            )
            Spacer(modifier = Modifier.padding(15.dp))

            Row(modifier = Modifier.padding(start = 30.dp, end=50.dp, bottom = 10.dp)
            ) {
                Text(
                    text = "$${videojuego.precio}",
                    fontSize = 35.sp,
                    fontWeight = FontWeight.Bold,
                    color= Color(0xFF5FBB88)
                    )

                Text(
                    modifier = Modifier.padding(start=10.dp),
                    text ="-${descuento}% OFF",
                    fontSize = 20.sp,
                    color= Color(0xFFB74343)
                )

            }
            Spacer(modifier = Modifier.padding(5.dp))

            Button(
                onClick = {
                },
                modifier = Modifier.fillMaxWidth()
                    .size(300.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF6C63FF)
                )
            ) {
                Text(
                    text = "Comprar juego por $${"%.2f".format(precioFinal)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
            Spacer(modifier = Modifier.padding(5.dp))
            Button(
                onClick = {
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
                    .size(300.dp, 50.dp)
                    .align(Alignment.CenterHorizontally),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.White,
                    containerColor = Color(0xFF8B85D2)
                )
            ) {
                Text(
                    text = "Volver al catálogo",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }

        }
    }
