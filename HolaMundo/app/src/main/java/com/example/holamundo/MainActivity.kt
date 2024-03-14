package com.example.holamundo

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)

        val buttonHola = findViewById<Button>(R.id.button_hola)
        buttonHola.setOnClickListener {
            val nombre = editText.text.toString().trim()
            if (nombre.isNotEmpty()) {
                mostrarDialogo("Hola $nombre")
            } else {
                mostrarDialogo("Por favor, ingresa tu nombre primero")
            }
        }

        val buttonBorrar = findViewById<Button>(R.id.button_borrar)
        buttonBorrar.setOnClickListener {
            editText.text.clear()
            mostrarDialogo("Ya no recuerdo tu nombre")
        }
    }

    private fun mostrarDialogo(mensaje: String) {
        val builder = AlertDialog.Builder(this)
        builder.setMessage(mensaje)
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }
}
