sealed class Estados {
    object Idle : Estados() {
        fun onEnter() {
            print("Estado actual: Idle")
            nivel_actual = 0

            val boton = ultimo_boton

            if (boton == Botonera_interior.nivel_1) {
                println("Boton pulsado: ${boton.lugar}. Subiendo")
                estado_acual = MovingUP
            }

            else if (boton == Botonera_interior.nivel_0) {
                println("Boton pulsado: ${boton.lugar}. Bajando")
                estado_acual = MovingDOWN
            }

            else {
                print("El ascensor sigue en Idle")
            }
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

            nivel_actual = 1
            print("Llegada a Plaza de Compostela - Nivel $nivel_actual")
            estado_acual = Idle
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

            nivel_actual = 0
            println("Llegada a Avenida G. Barbón - Nivel $nivel_actual")
            estado_acual = Idle
        }
    }

    object Error : Estados() {
        fun onEnter() {
            print("Estado actual: Error")
            nivel_actual = -1
            print("Estado actual: Idle")
            estado_acual = Idle
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
