package com.example.figuras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SquareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_square)

        val sideInput: EditText = findViewById(R.id.side_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultText: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val side = sideInput.text.toString().toDoubleOrNull()
            if (side != null) {
                val area = side * side
                resultText.text = "Área del cuadrado: $area"
            } else {
                resultText.text = "Por favor, introduce un valor válido para el lado."
            }
        }
    }
}
