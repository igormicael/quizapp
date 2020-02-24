package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var intent: Intent = this.intent
        var bundle = intent.getBundleExtra("bundle")

        var questionsSize = bundle?.getInt("questionsSize")
        var correctAnswers = bundle?.getInt("correctAnswers")

        result.text =
            "Congrats! You got " + correctAnswers + " of " + questionsSize + " questions right! "

        newGame.setOnClickListener {
            val i = Intent(this, GameActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}
