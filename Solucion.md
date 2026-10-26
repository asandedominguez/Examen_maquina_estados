# EXPLICACIÓN DEL FUNCIONAMIENTO DE LA MÁQUINA DE ESTADOS

## CLASE ESTADOS

Se envuelve todo en una **sealed class** llamada _"Estados"_ que contendrá los *estados** en objetos.

En cada estado se mostrará:
1. El estado en el que se encuentra al principio.
2. El nivel
3. Logica de lo que harña el programa
4. Estado fianl

- ESTADO - Idle:
1. Si el último botón equivale al nivel 1 mostrará que se esta llendo hacia el y el estado en el que se encontrará
2. Si es el 0 lo mismo pero al contrario
3. Si no se pulsó ninguno se mantendrá en Idle

- ESTADO - MovingUP
1. Se muestra el estado MovingUP
2. El nivel actual pasará a 2 y se mostrará que esta moviendose
3. Pasa a nivel 1 y se muestra el destino
4. Al final se quedará en estado Idle

- ESTADO - MovingDown
1. Lo mismo pero al contrario

- ESTADO - Error
1. Se muestra el estado de error se pasa al nivel correspondiente
2. Vueleve a Idle

Se define una **enum class** con los botones y sus destinos con una variable tipo String

## CLASE GESTOR 

### VARIABLES UTILIZADAS
| Variable | Dato | Función |
| :--- | :--- | :--- |
| nivel_actual | Int | Indica el nivel en el que está la máquina. |
| estado_acual | Objetos Estados | Guarda el estado en el que se encuentra la máquina |
| ultimo_boton | Objetos Botonera_interior | Guarda el último botón introducido. |

Se crea una función con un gestor que hará lo siguiente si la botonera no tiene un valor nulo:
1. Si el boton no es nulo comprobará el botón que pulsamos y el lugar a donda va el ascensor
2. Se recorren todos los estados y se transicionan entre ellos. Se returna el resultado.

## TEST

![1](/Capturas/1.png)
