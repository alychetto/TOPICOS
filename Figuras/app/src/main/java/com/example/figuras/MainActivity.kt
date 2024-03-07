package com.example.figuras

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val circleButton: RadioButton = findViewById(R.id.circle_button)
        val squareButton: RadioButton = findViewById(R.id.square_button)
        val trapezoidButton: RadioButton = findViewById(R.id.trapezoid_button)
        val triangleButton: RadioButton = findViewById(R.id.triangle_button)
        val proceedButton: Button = findViewById(R.id.proceed_button)

        proceedButton.setOnClickListener {
            when {
                circleButton.isChecked -> startActivity(Intent(this, CircleActivity::class.java))
                squareButton.isChecked -> startActivity(Intent(this, SquareActivity::class.java))
                trapezoidButton.isChecked -> startActivity(Intent(this, TrapezoidActivity::class.java))
                triangleButton.isChecked -> startActivity(Intent(this, TriangleActivity::class.java))
            }
        }
    }
}
