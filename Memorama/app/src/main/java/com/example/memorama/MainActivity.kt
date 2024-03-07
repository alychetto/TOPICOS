package com.example.memorama
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val images = mutableListOf<Int>()
    private var firstCard: ImageView? = null
    private var secondCard: ImageView? = null
    private var gamePaused = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayout: GridLayout = findViewById(R.id.gridLayout)
        val restartButton: Button = findViewById(R.id.restartButton)

        restartButton.setOnClickListener {
            resetGame()
        }

        // Añadir todas las cartas al conjunto de imágenes
        for (i in 1..8) {
            images.add(resources.getIdentifier("img$i", "drawable", packageName))
            images.add(resources.getIdentifier("img$i", "drawable", packageName))
        }
        images.shuffle()

        // Crear e inicializar las tarjetas de memoria
        for (i in 0 until gridLayout.childCount) {
            val card: ImageView = gridLayout.getChildAt(i) as ImageView
            card.setImageResource(R.drawable.card_back) // Establecer imagen de respaldo
            val imageIndex = i % images.size // Obtener el índice de la imagen
            card.setTag(R.id.image_tag, images[imageIndex]) // Establecer etiqueta de la imagen
            card.setOnClickListener {
                if (!gamePaused && card != firstCard) {
                    if (firstCard == null) {
                        firstCard = card
                        flipCard(firstCard!!, firstCard!!.getTag(R.id.image_tag) as Int)
                    } else if (secondCard == null) {
                        secondCard = card
                        flipCard(secondCard!!, secondCard!!.getTag(R.id.image_tag) as Int)
                        checkMatch()
                    }
                }
            }
        }
    }

    private fun flipCard(card: ImageView, imageId: Int) {
        card.setImageResource(imageId)
    }

    private fun checkMatch() {
        gamePaused = true
        if (firstCard?.getTag(R.id.image_tag) == secondCard?.getTag(R.id.image_tag)) {
            firstCard?.setOnClickListener(null)
            secondCard?.setOnClickListener(null)
            clearCards()
        } else {
            firstCard?.postDelayed({
                flipCard(firstCard!!, R.drawable.card_back)
                flipCard(secondCard!!, R.drawable.card_back)
                clearCards()
            }, 1000)
        }
    }

    private fun clearCards() {
        firstCard = null
        secondCard = null
        gamePaused = false
    }

    private fun resetGame() {
        recreate()
    }
}
