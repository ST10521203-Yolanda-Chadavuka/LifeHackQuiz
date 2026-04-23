package com.example.lifehackapp3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {

    private val questions = arrayOf(
        "Putting a wet phone in rice will fully fix water damage.",
        "Using a frozen spoon can help reduce puffy eyes.",
        "Cracking your knuckles always causes arthritis.",
        "Drinking water improves skin health.",
        "Microwaving food destroys all nutrients."
    )

    private val answers = arrayOf(false, true, false, true, false)

    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val questionText = findViewById<TextView>(R.id.questionText)
        val trueButton = findViewById<Button>(R.id.trueButton)
        val falseButton = findViewById<Button>(R.id.falseButton)
        val nextButton = findViewById<Button>(R.id.nextButton)

// show first question
        questionText.text = questions[currentIndex]

        trueButton.setOnClickListener {
            if (!answered) {
                checkAnswer(true)
                answered = true

// disable buttons
                trueButton.isEnabled = false
                falseButton.isEnabled = false
            }
        }

        falseButton.setOnClickListener {
            if (!answered) {
                checkAnswer(false)
                answered = true

// disable buttons
                trueButton.isEnabled = false
                falseButton.isEnabled = false
            }
        }

        nextButton.setOnClickListener {

            currentIndex++
            answered = false

            if (currentIndex < questions.size) {
                questionText.text = questions[currentIndex]

// re-enable buttons for next question
                trueButton.isEnabled = true
                falseButton.isEnabled = true

            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("SCORE", score)
                startActivity(intent)
            }
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (userAnswer == answers[currentIndex]) {
            score++
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show()
        }
    }
}