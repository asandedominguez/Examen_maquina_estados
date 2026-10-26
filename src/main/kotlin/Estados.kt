sealed class Estados {
    object Idle : Estados()
    object MovingUP : Estados()
    object MovingDOWN : Estados()
    object Error : Estados()
}

enum class Botonera_interior {
    nivel_0,
    nivel_1
}