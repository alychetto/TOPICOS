package com.example.ventanassimple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBackToMain: Button = findViewById(R.id.buttonBackToMain)

        // Configurar el botón para volver a la actividad principal
        buttonBackToMain.setOnClickListener {
            finish()
        }
    }
}
