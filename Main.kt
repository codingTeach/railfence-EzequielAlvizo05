package org.example
import javax.swing.JOptionPane

fun codificarMensaje(mensaje: String): ArrayList<Char> {
    var contador = 0
    var salto = 0
    var auxiliar = 0
    var iniciado = false
    val mensajeCodificado = ArrayList<Char>()

    while (contador <= 2) {
        for ((indice, caracter) in mensaje.withIndex()) {
            println("Contador: $contador")
            println("Índice: $indice")
            println("Carácter: $caracter")
            println("Auxiliar: $auxiliar")

            salto = when (contador) {
                0, 2 -> 3
                1 -> 1
                else -> 0
            }

            if (indice != contador && !iniciado) {
                println("Saltando")
                continue
            } else {
                iniciado = true
            }

            if (auxiliar == salto || indice == contador) {
                mensajeCodificado.add(caracter)
                auxiliar = 0
                println("Añadido")
            } else {
                auxiliar += 1
            }

            println("-------------------")
        }

        auxiliar = 0
        iniciado = false
        contador += 1
    }

    return mensajeCodificado
}

fun decodificarMensaje(mensaje: String): ArrayList<Char> {
    val mensajeDecodificado = ArrayList<Char>(mensaje.length).apply {
        for (i in 0 until mensaje.length) {
            add(' ')
        }
    }

    var contador = 0
    var auxiliar = 0
    var iniciado = false
    var salto = 0
    var indiceDecodificado = 0

    while (contador <= 2) {
        for ((indice, _) in mensaje.withIndex()) {
            salto = when (contador) {
                0, 2 -> 3
                1 -> 1
                else -> 0
            }

            if (indice != contador && !iniciado) {
                continue
            } else {
                iniciado = true
            }

            if (auxiliar == salto || indice == contador) {
                mensajeDecodificado[indice] = mensaje[indiceDecodificado]
                indiceDecodificado++
                auxiliar = 0
            } else {
                auxiliar += 1
            }
        }

        auxiliar = 0
        iniciado = false
        contador += 1
    }

    return mensajeDecodificado
}

fun main() {
    val opcion = JOptionPane.showInputDialog("Elige una opción:\n1. Codificar\n2. Decodificar")

    when (opcion) {
        "1" -> {
            val mensaje = JOptionPane.showInputDialog("Introduce el mensaje a codificar:")
            if (mensaje != null) {
                val mensajeCodificado = codificarMensaje(mensaje)
                JOptionPane.showMessageDialog(null, "El mensaje codificado es: $mensajeCodificado")
            }
        }
        "2" -> {
            val mensaje = JOptionPane.showInputDialog("Introduce el mensaje a decodificar:")
            if (mensaje != null) {
                val mensajeDecodificado = decodificarMensaje(mensaje)
                JOptionPane.showMessageDialog(null, "El mensaje decodificado es: $mensajeDecodificado")
            }
        }
        else -> {
            println("Opción no válida")
        }
    }
}
