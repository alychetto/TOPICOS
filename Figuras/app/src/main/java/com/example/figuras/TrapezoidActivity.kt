package com.example.figuras

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class TrapezoidActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapezoid)

        val base1Input: EditText = findViewById(R.id.base1_input)
        val base2Input: EditText = findViewById(R.id.base2_input)
        val heightInput: EditText = findViewById(R.id.height_input)
        val calculateButton: Button = findViewById(R.id.calculate_button)
        val resultText: TextView = findViewById(R.id.result_text)

        calculateButton.setOnClickListener {
            val base1 = base1Input.text.toString().toDoubleOrNull()
            val base2 = base2Input.text.toString().toDoubleOrNull()
            val height = heightInput.text.toString().toDoubleOrNull()

            if (base1 != null && base2 != null && height != null) {
                val area = 0.5 * (base1 + base2) * height
                resultText.text = "Área del trapecio: $area"
            } else {
                resultText.text = "Por favor, introduce valores válidos para las bases y la altura."
            }
        }
    }
}
