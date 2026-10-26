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
        print("Botón: ${ultimo_boton?.name} Destino: ${ultimo_boton?.lugar}")
    }

    when (estado_acual) {
        is Estados.Idle -> {
            Estados.Idle.onEnter()
        }
        is Estados.MovingUP -> {
            Estados.MovingUP.onEnter()
        }
        is Estados.MovingDOWN -> {
            Estados.MovingDOWN.onEnter()
        }
        is Estados.Error -> {
            Estados.Error.onEnter()
        }
    }
    return nivel_actual;
}
