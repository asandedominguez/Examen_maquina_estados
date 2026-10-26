var nivel_actual: Int = 0
// estado actual del ascensor
var estado_acual: Estados = Estados.Idle

var ultimo_boton : Botonera_interior? = null

/**
 * Gestiona el cambio de estados
 */
fun gestor(boton: Botonera_interior?= null): Int {

    if (boton != null) {
        ultimo_boton = boton
        print("Botón pulsado: ${ultimo_boton?.name} -> Destino: ${ultimo_boton?.lugar}")
    }

    when (estado_acual) {
        is Estados.Idle -> {
            nivel_actual = 0
            return nivel_actual
        }
        is Estados.MovingUP -> {
            nivel_actual = 2
            return nivel_actual
        }
        is Estados.MovingDOWN -> {
            nivel_actual = 2
            return nivel_actual
        }
        is Estados.Error -> {
            nivel_actual = -1
            return nivel_actual
        }
    }
}
