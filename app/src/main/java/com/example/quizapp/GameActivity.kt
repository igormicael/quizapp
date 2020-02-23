package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizapp.action.QuestionAction
import com.example.quizapp.model.Alternativa
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    var correctAnswers = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val bundle = Bundle()
        val fragment = QuestionFragment.newInstance(bundle)

        //activity irá começar com o jogo, o resultado só será mostrado ao final do jogo
        result.visibility = View.GONE

        supportFragmentManager.
            beginTransaction()
            .add(R.id.questions, fragment)
            .commit()
    }

}
