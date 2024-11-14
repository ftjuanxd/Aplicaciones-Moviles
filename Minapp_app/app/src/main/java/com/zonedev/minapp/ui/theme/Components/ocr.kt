package com.zonedev.minapp.ui.theme.Components

import com.googlecode.tesseract.android.TessBaseAPI
import android.graphics.Bitmap
import com.google.firebase.firestore.FirebaseFirestore

fun recognizeText(bitmap: Bitmap): String {
    val tessBaseAPI = TessBaseAPI()
    tessBaseAPI.init(context.filesDir.absolutePath, "spa")
    tessBaseAPI.setImage(bitmap)
    val recognizedText = tessBaseAPI.utF8Text
    tessBaseAPI.end()
    return recognizedText
}

fun saveTextToFirestore(recognizedText: String) {
    val db = FirebaseFirestore.getInstance()
    val ocrData = hashMapOf(
        "text" to recognizedText,
        "timestamp" to System.currentTimeMillis()
    )
    db.collection("ocr_results")
        .add(ocrData)
        .addOnSuccessListener { documentReference ->
            println("Texto guardado con ID: ${documentReference.id}")
        }
        .addOnFailureListener { e ->
            println("Error al guardar texto: $e")
        }
}
