import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

class GestorTest {
    @BeforeTest
    fun restaurarEstados() {
        estado_acual = Estados.Idle
        nivel_actual = 0
    }

    @AfterTest
    fun restaurarEstado() {
        estado_acual = Estados.Idle
        nivel_actual = 0
    }

    private fun resetAscensor() {
        estado_acual = Estados.Idle
        nivel_actual = 0
        ultimo_boton = null
    }

    @Test
    fun `gestor reinicia el nivel cuando el estado es Idle`() {
        estado_acual = Estados.Idle
        nivel_actual = 5

        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingUP`() {
        estado_acual = Estados.MovingUP
        nivel_actual = 5

        assertEquals(1, gestor())
        assertEquals(1, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel cuando el estado es MovingDOWN`() {
        estado_acual = Estados.MovingDOWN
        nivel_actual = 5

        assertEquals(0, gestor())
        assertEquals(0, nivel_actual)
    }

    @Test
    fun `gestor establece el nivel de error cuando el estado es Error`() {
        estado_acual = Estados.Error
        nivel_actual = 5

        assertEquals(-1, gestor())
        assertEquals(-1, nivel_actual)
    }

    @Test
    fun MovingUP_Idle() {
        resetAscensor()
        estado_acual = Estados.Idle
        gestor(Botonera_interior.nivel_1)

        assertEquals(Estados.MovingUP, estado_acual)

        gestor()
        assertEquals(1, nivel_actual)
        assertEquals(Estados.Idle, estado_acual)
    }

    @Test
    fun MovingDOWN_Idle() {
        resetAscensor()
        estado_acual = Estados.Idle
        gestor(Botonera_interior.nivel_0)

        assertEquals(Estados.MovingDOWN, estado_acual)

        gestor()
        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_acual)
    }

    @Test
    fun Test_IdleSinPeticion() {
        resetAscensor()
        estado_acual = Estados.Idle
        ultimo_boton = null
        nivel_actual = 5

        val resultado = gestor()

        assertEquals(0, resultado)
        assertEquals(0, nivel_actual)
        assertEquals(Estados.Idle, estado_acual)
    }

}