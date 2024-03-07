package com.example.juegoxo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.widget.GridLayout

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var gridLayout: GridLayout
    private lateinit var resetButton: Button
    private var playerX: Boolean = true
    private var gameOver: Boolean = false
    private var moves = Array(3) { IntArray(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        gridLayout = findViewById(R.id.gridLayout)
        resetButton = findViewById(R.id.resetButton)

        resetButton.setOnClickListener {
            resetGame()
        }
    }

    fun onImageClick(view: View) {
        if (view is ImageView && !gameOver) {
            val columnIndex = (view.x / view.width).toInt()
            val rowIndex = (view.y / view.height).toInt()

            if (moves[rowIndex][columnIndex] == 0) {
                if (playerX) {
                    (view as ImageView).setImageResource(R.drawable.x)
                    textView.text = "Turno del jugador O"
                    moves[rowIndex][columnIndex] = 1
                } else {
                    (view as ImageView).setImageResource(R.drawable.o)
                    textView.text = "Turno del jugador X"
                    moves[rowIndex][columnIndex] = -1
                }

                if (checkWin(rowIndex, columnIndex)) {
                    val winner = if (playerX) "Jugador X" else "Jugador O"
                    textView.text = "$winner ha ganado!"
                    gameOver = true
                } else if (checkDraw()) {
                    textView.text = "Empate!"
                    gameOver = true
                }

                playerX = !playerX
            }
        }
    }

    private fun checkWin(row: Int, col: Int): Boolean {
        // Check row
        if (moves[row][0] + moves[row][1] + moves[row][2] == 3 ||
            moves[0][col] + moves[1][col] + moves[2][col] == 3 ||
            moves[0][0] + moves[1][1] + moves[2][2] == 3 ||
            moves[0][2] + moves[1][1] + moves[2][0] == 3
        ) {
            return true
        }

        // Check column
        if (moves[row][0] + moves[row][1] + moves[row][2] == -3 ||
            moves[0][col] + moves[1][col] + moves[2][col] == -3 ||
            moves[0][0] + moves[1][1] + moves[2][2] == -3 ||
            moves[0][2] + moves[1][1] + moves[2][0] == -3
        ) {
            return true
        }

        return false
    }

    private fun checkDraw(): Boolean {
        for (row in moves) {
            for (move in row) {
                if (move == 0) {
                    return false
                }
            }
        }
        return true
    }

    private fun resetGame() {
        // Reiniciar la matriz de movimientos
        moves = Array(3) { IntArray(3) }

        // Reiniciar el texto
        textView.text = "Turno del jugador X"

        // Reiniciar las imágenes
        for (i in 0 until gridLayout.childCount) {
            val child = gridLayout.getChildAt(i)
            if (child is ImageView) {
                child.setImageResource(R.drawable.empty)
            }
        }

        // Reiniciar variables de control
        playerX = true
        gameOver = false
    }
}
