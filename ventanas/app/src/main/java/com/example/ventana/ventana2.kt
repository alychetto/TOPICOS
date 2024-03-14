package com.example.ventana2

import  android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ventana.MainActivity
import com.example.ventana.R


class ventana2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val boton2 : Button = findViewById(R.id.boton2)

        boton2.setOnClickListener {
            var v2: Intent=Intent(this, MainActivity::class.java)
            startActivity(v2)
        }
    }
}
