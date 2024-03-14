package com.example.juegoxo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var imageView1: ImageView? = null
    var imageView2: ImageView? = null
    var imageView3: ImageView? = null
    var imageView4: ImageView? = null
    var imageView5: ImageView? = null
    var imageView6: ImageView? = null
    var imageView7: ImageView? = null
    var imageView8: ImageView? = null
    var imageView9: ImageView? = null
    var imageViewX: ImageView? = null
    var imageViewO: ImageView? = null
    var turno = "x"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        imageView1 = findViewById(R.id.imageView1)
        imageView2 = findViewById(R.id.imageView2)
        imageView3 = findViewById(R.id.imageView3)
        imageView4 = findViewById(R.id.imageView4)
        imageView5 = findViewById(R.id.imageView5)
        imageView6 = findViewById(R.id.imageView6)
        imageView7 = findViewById(R.id.imageView7)
        imageView8 = findViewById(R.id.imageView8)
        imageView9 = findViewById(R.id.imageView9)



    }

    fun clickImagen(view: View) {
        if (turno == "x") {
            view.setBackgroundResource(R.drawable.circuloRojo)
            imageViewX?.setBackgroundColor(Color.WHITE)
            imageViewO?.setBackgroundColor(Color.RED)
            turno = "o"
        }else{
            view.setBackgroundResource(R.drawable.circuloVerde)
            imageViewX?.setBackgroundColor(Color.WHITE)
            imageViewO?.seBackgroundColor(Color.RED)
            turno = "o"
        }
        view.isEnabled=false

    }
}
