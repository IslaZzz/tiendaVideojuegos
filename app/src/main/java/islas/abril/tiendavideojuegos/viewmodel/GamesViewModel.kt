package islas.abril.tiendavideojuegos.viewmodel

import androidx.compose.runtime.mutableStateListOf
import islas.abril.tiendavideojuegos.dummies.listaDeJuegos
import islas.abril.tiendavideojuegos.model.Videojuego
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class GamesViewModel : ViewModel() {

    var listaJuegos = mutableStateListOf<Videojuego>()
        private set

    init {
        cargarJuegos()
    }

    private fun cargarJuegos() {
        listaJuegos.addAll(listaDeJuegos)
    }

    fun aplicarDescuento(precio: Double): Pair<Double, Int> {
        val descuento = Random.nextInt(0, 101) // 0% a 100%

        val precioFinal = precio - (precio * descuento / 100)

        return Pair(precioFinal, descuento)
    }
}