package com.zonedev.minapp.ui.theme.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.zonedev.minapp.ui.theme.Model.Reporte
import java.text.SimpleDateFormat
import java.util.Locale

fun crearParametrosParaReporte(tipo: String, datos: Map<String, Any?>): Map<String, Any> {
    return when (tipo) {
        "Observations" -> {
            mapOf(
                "subject" to (datos["subject"] ?: ""),
                "observation" to (datos["observation"] ?: ""),
                "evidencias" to (datos["evidencias"] ?: "Ninguna"),
            )
        }
        "Personal" -> {
            mapOf(
                "id_placa" to (datos["id_placa"] ?: ""),
                "name" to (datos["name"] ?:""),
                "destino" to (datos["destino"] ?: ""),
                "autorizacion" to (datos["autorizacion"]?: ""),
                "descripcion" to (datos["descripcion"]?: "")
            )
        }
        "Vehicular" -> {
            mapOf(
                "id_placa" to (datos["id_placa"] ?: ""),
                "name" to (datos["name"] ?: ""),
                "destino" to (datos["destino"] ?: ""),
                "autorizacion" to (datos["autorizacion"]?: ""),
                "descripcion" to (datos["descripcion"]?: "")
            )
        }
        "Elemento" -> {
            mapOf(
                "imgelement" to (datos["imgelement"] ?: ""),
                "id_placa" to (datos["id_placa"] ?: ""),
                "name" to (datos["name"] ?:""),
                "destino" to (datos["destino"] ?: ""),
                "autorizacion" to (datos["autorizacion"]?: ""),
                "descripcion" to (datos["descripcion"]?: "")
            )
        }
        else -> emptyMap() // Manejo de casos de tipos desconocidos
    }
}

@Composable
fun MostrarReporte(reporte: Reporte) {
    Column {
        Text(text="${formatearFecha(reporte.timestamp)}")

        // Verificar si `parametros` tiene algún valor.
        if (reporte.parametros.isNotEmpty()) {
            reporte.parametros.forEach { (key, value) ->
                Text(text = "$key: $value") // Muestra cada clave y valor en `parametros`
            }
        } else {
            Text(text = "No hay parámetros disponibles")
        }
    }
}


fun formatearFecha(timestamp: Long): String {
    val sdf = SimpleDateFormat("EEE, d MMM yyyy - h:mm a", Locale.getDefault())
    return sdf.format(timestamp)
}
fun obtenerParametro(reporte: Reporte, clave: String): String {
    return reporte.parametros[clave]?.toString() ?: "Parámetro no encontrado"
}
fun obtenerClavePorTipo(tipo: String): String {
    return when (tipo) {
        "Observations" -> "subject"
        "Personal" -> "id_placa"
        "Vehicular" -> "id_placa"
        "Elementos" -> "id_placa"
        else -> "unknown"
    }
}
