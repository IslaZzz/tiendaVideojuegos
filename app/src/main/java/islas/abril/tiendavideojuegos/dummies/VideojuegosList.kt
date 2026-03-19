package islas.abril.tiendavideojuegos.dummies
import islas.abril.tiendavideojuegos.R
import islas.abril.tiendavideojuegos.model.Videojuego
import kotlin.Double
import kotlin.String
import kotlin.collections.listOf


var listaDeJuegos = listOf<Videojuego>(

   Videojuego(
       "Metroid Dread",
       60.99,
       "Accion",
       "Metroid Dread, es un videojuego de acción-aventura de 2021 de la serie Metroid, desarrollado por MercurySteam en colaboración con la filial Nintendo EPD y publicado por Nintendo para la consola Nintendo Switch.",
       R.drawable.postermetroid
       ),
    Videojuego(
        "DOOM Eternal",
        59.99,
        "Shooter",
        "DOOM Eternal es un videojuego de disparos en primera persona de 2020 desarrollado por id Software y publicado por Bethesda. Es la secuela de DOOM (2016) y destaca por su combate rápido, violento y estratégico contra demonios.",
        R.drawable.posterdoom
    ),

    Videojuego(
        "Silent Hill 2",
        49.99,
        "Terror",
        "Silent Hill 2 es un videojuego de terror psicológico desarrollado por Konami. Sigue la historia de James Sunderland mientras explora el misterioso pueblo de Silent Hill en busca de su esposa.",
        R.drawable.postersilenthill
    ),

    Videojuego(
        "Resident Evil 4",
        39.99,
        "Terror",
        "Resident Evil 4 es un videojuego de acción y survival horror desarrollado por Capcom. Sigue a Leon S. Kennedy en una misión para rescatar a la hija del presidente en una aldea infestada.",
        R.drawable.posterresidentevil
    ),

    Videojuego(
        "Minecraft",
        26.95,
        "Sandbox",
        "Minecraft es un videojuego de construcción y aventura desarrollado por Mojang donde los jugadores pueden explorar, recolectar recursos y crear mundos en un entorno generado de forma procedural.",
        R.drawable.posterminecraft
    ),

    Videojuego(
        "The Legend of Zelda: Breath of the Wild",
        59.99,
        "Aventura",
        "The Legend of Zelda: Breath of the Wild es un videojuego de mundo abierto desarrollado por Nintendo donde el jugador explora Hyrule con total libertad, resolviendo acertijos y enfrentando enemigos.",
        R.drawable.posterzelda
    )
)

fun obtenerVideojuegos(): List<Videojuego>{
    return listaDeJuegos
 }

fun obtenerVideojuegoRandom(): Videojuego{
    return listaDeJuegos.random()
}