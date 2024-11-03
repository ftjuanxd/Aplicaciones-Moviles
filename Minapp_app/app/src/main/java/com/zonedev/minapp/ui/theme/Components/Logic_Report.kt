package com.zonedev.minapp.ui.theme.Components

fun crearParametrosParaReporte(tipo: String, datos: Map<String, Any?>): Map<String, Any> {
    return when (tipo) {
        "Observations" -> {
            mapOf(
                "subject" to (datos["subject"] ?: ""),
                "observation" to (datos["observation"] ?: ""),
                "evidencias" to (datos["evidencias"] ?: "Ninguna"),
            )
        }
        "Acceso a Personas" -> {
            mapOf(
                "personaNombre" to (datos["personaNombre"] ?: ""),
                "horaEntrada" to (datos["horaEntrada"] ?: System.currentTimeMillis()),
                "autorizadoPor" to (datos["autorizadoPor"] ?: "")
            )
        }
        "Vehicular" -> {
            mapOf(
                "placa" to (datos["placa"] ?: ""),
                "marca" to (datos["marca"] ?: ""),
                "modelo" to (datos["modelo"] ?: ""),
                "horaIngreso" to (datos["horaIngreso"] ?: System.currentTimeMillis())
            )
        }
        "Elementos" -> {
            mapOf(
                "elementoNombre" to (datos["elementoNombre"] ?: ""),
                "cantidad" to (datos["cantidad"] ?: 0),
                "estado" to (datos["estado"] ?: "bueno")
            )
        }
        else -> emptyMap() // Manejo de casos de tipos desconocidos
    }
}