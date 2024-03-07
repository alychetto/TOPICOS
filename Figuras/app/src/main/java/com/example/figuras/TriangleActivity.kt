package com.example.figuras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TriangleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triangle)

        val baseInput: EditText = findViewById(R.id.base_input)
        val heightInput: EditText = findViewById(R.id.height_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultText: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val base = baseInput.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (base != null && height != null) {
                val area = 0.5 * base * height
                resultText.text = "Área del triángulo: $area"
            } else {
                resultText.text = "Por favor, introduce valores válidos para la base y la altura."
            }
        }
    }
}
