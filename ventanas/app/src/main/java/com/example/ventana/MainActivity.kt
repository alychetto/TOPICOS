package com.example.ventana

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.ventana2.ventana2


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val boton1 : Button = findViewById(R.id.boton1)

        boton1.setOnClickListener {
            var v1: Intent=Intent(this, ventana2::class.java)
            startActivity(v1)
        }
    }
}