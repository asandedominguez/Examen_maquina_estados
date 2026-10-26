sealed class Estados {
    object Idle : Estados() {
        fun onEnter() {
            print("Estado actual: Idle")
            nivel_actual = 0
            print("Estado actual: Reposo, nivel $nivel_actual - Avenida G. Barbón")

        }

        override fun toString() : String {
            return "Idle"
        }
    }

    object MovingUP : Estados() {
        fun onEnter() {
            print("Estado actual: MovingUP")
            nivel_actual = 2
            print("Estado actual: Subiendo, moviendose - Nivel $nivel_actual")
        }

        override fun toString() : String {
            return "MovingUp"
        }

    }

    object MovingDOWN : Estados() {
        fun onEnter() {
            print("Estado actual: MovingDOWN")
            nivel_actual = 2
            print("Estado actual: Bajando - Nivel $nivel_actual")
        }
    }

    object Error : Estados() {
        fun onEnter() {
            print("Estado actual: Error")
            nivel_actual = -1
            print("Estado actual: Idle")
        }

        override fun toString() : String {
            return "Error"
        }
    }

}

enum class Botonera_interior (
    val lugar : String
) {
    nivel_0("Avenida G. Barbón"),
    nivel_1("Plaza de Compostela")
}
