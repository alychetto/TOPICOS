package com.example.aplicacion2

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextCantidad: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextCantidad = findViewById(R.id.editTextCantidad)

        val buttonCalcularImpuesto = findViewById<Button>(R.id.buttonCalcularImpuesto)
        buttonCalcularImpuesto.setOnClickListener {
            val cantidadTexto = editTextCantidad.text.toString().trim()
            if (cantidadTexto.isNotEmpty()) {
                val cantidad = cantidadTexto.toDouble()
                val impuesto = cantidad * 0.16
                mostrarDialogo("El impuesto realizado a $cantidadTexto es de $impuesto")
            } else {
                mostrarDialogo("Por favor, ingresa una cantidad primero")
            }
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
