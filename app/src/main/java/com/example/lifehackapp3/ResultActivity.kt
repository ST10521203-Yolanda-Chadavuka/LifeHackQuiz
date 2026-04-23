package com.example.lifehackapp3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("SCORE", 0)

        val resultText = findViewById<TextView>(R.id.resultText)
        val feedbackText = findViewById<TextView>(R.id.feedbackText)
        val reviewText = findViewById<TextView>(R.id.reviewText)
        val reviewButton = findViewById<Button>(R.id.reviewButton)

        resultText.text = "Your Score: $score / 5"

        if (score == 5) {
            feedbackText.text = "Master Hacker! You got all answers correct."
        } else if (score >= 3) {
            feedbackText.text = "Good Job! You know most of these."
        } else {
            feedbackText.text = "Keep Practising! You'll get better."
        }

        reviewText.text =
            "Review Answers:\n\n" +

                    "1. Putting a wet phone in rice fixes water damage\n" +
                    "Answer: Myth ❌\n" +
                    "Explanation: Rice does not properly remove moisture and can damage the phone further.\n\n" +

                    "2. Using a frozen spoon reduces puffy eyes\n" +
                    "Answer: Hack ✅\n" +
                    "Explanation: Cold temperature reduces swelling and improves blood circulation.\n\n" +

                    "3. Cracking knuckles causes arthritis\n" +
                    "Answer: Myth ❌\n" +
                    "Explanation: Studies show no direct link between knuckle cracking and arthritis.\n\n" +

                    "4. Drinking water improves skin health\n" +
                    "Answer: Hack ✅\n" +
                    "Explanation: Proper hydration helps maintain skin elasticity and overall health.\n\n" +

                    "5. Microwaving food destroys all nutrients\n" +
                    "Answer: Myth ❌\n" +
                    "Explanation: Microwaving actually preserves nutrients better than some other cooking methods."

        reviewText.visibility = TextView.GONE

        reviewButton.setOnClickListener {
            if (reviewText.visibility == TextView.GONE) {
                reviewText.visibility = TextView.VISIBLE
                reviewButton.text = "Hide Review"
            } else {
                reviewText.visibility = TextView.GONE
                reviewButton.text = "Review"
            }
        }
    }
}


