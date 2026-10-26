sealed class Estados {
    object Idle : Estados()
    object MovingUP : Estados()
    object MovingDOWN : Estados()
    object Error : Estados()
}

enum class Botonera_interior (
    val lugar : String
) {
    nivel_0("Avenida G. Barbón"),
    nivel_1("Plaza de Compostela")
}