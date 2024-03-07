package com.example.figuras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CircleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)

        val radiusInput: EditText = findViewById(R.id.radius_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultText: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val radius = radiusInput.text.toString().toDoubleOrNull()
            if (radius != null) {
                val area = Math.PI * radius * radius
                resultText.text = "Área del círculo: $area"
            } else {
                resultText.text = "Por favor, introduce un valor válido para el radio."
            }
        }
    }
}
