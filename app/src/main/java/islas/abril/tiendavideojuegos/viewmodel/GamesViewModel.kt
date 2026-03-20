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

    var juegoSeleccionado: Videojuego? = null
        private set

    fun seleccionarJuego(juego: Videojuego) {
        juegoSeleccionado = juego
    }

    private fun cargarJuegos() {
        listaJuegos.addAll(listaDeJuegos)
    }
    fun obtenerJuegoID(id: Int): Videojuego? {
        return listaJuegos.find { it.id == id }
    }
    fun aplicarDescuento(precio: Double): Pair<Double, Int> {
        val descuento = Random.nextInt(0, 101)

        val precioFinal = precio - (precio * descuento / 100)

        return Pair(precioFinal, descuento)
    }
}