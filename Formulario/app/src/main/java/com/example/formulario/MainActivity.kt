package com.example.formulario

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextNombre: EditText
    private lateinit var editTextCorreo: EditText
    private lateinit var editTextTelefono: EditText
    private lateinit var buttonEnviar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNombre = findViewById(R.id.editTextNombre)
        editTextCorreo = findViewById(R.id.editTextCorreo)
        editTextTelefono = findViewById(R.id.editTextTelefono)
        buttonEnviar = findViewById(R.id.buttonEnviar)

        buttonEnviar.setOnClickListener {
            if (validarCampos()) {
                mostrarDialogo("Formulario enviado correctamente.")
            }
        }
    }

    private fun validarCampos(): Boolean {
        val nombre = editTextNombre.text.toString().trim()
        val correo = editTextCorreo.text.toString().trim()
        val telefono = editTextTelefono.text.toString().trim()

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            mostrarDialogo("Por favor, completa todos los campos.")
            return false
        }

        return true
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
