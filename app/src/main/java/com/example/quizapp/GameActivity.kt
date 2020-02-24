package com.example.quizapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.lists.AlternativeListAdapter
import com.example.quizapp.lists.OnAlternativeListener
import com.example.quizapp.model.Alternative
import com.example.quizapp.model.Question
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity(), OnAlternativeListener {

    override fun onAlternativaClick(position: Int) {

        var alternatives = questions[questionIndex].alternatives
        var alternative = alternatives[position]

        if (alternative.correct) {
            correctAnswers++
            Log.v("GameActivity", correctAnswers.toString())
        }

    }

    var questionIndex = 0

    var correctAnswers = 0

    var questions: ArrayList<Question> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        try {

            for (i in 0..9) {
                createQuestionsList(i)
            }

            if (this.questions.isNotEmpty()) {
                showQuestions(0)
            }

            var nextQuestion = proxima_questao
            nextQuestion.setOnClickListener {

                var indexAdded = ++questionIndex

                if (indexAdded <= 9) {
                    showQuestions(indexAdded)
                } else {

                    val intent = Intent(this, ResultActivity::class.java)
                    val b = Bundle()
                    b.putInt("questionsSize", questions.size)
                    b.putInt("correctAnswers", correctAnswers)
                    intent.putExtra("bundle", b)
                    startActivity(intent)
                    finish()

                }
            }

        } catch (e: java.lang.Exception) {
            Log.w("GameActivity", e.printStackTrace().toString())
        }
    }

    private fun showQuestions(showQuestionsIndex: Int) {

        var innerQuestion = questions[showQuestionsIndex]

        val questionImage = question_image

        Picasso.get()
            .load(innerQuestion.imgSrc)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .into(questionImage)

        var enunciado = enunciado

        enunciado.text = "Questão " + (showQuestionsIndex + 1) + " : " + innerQuestion.text

        var alternativas = alternativas
        alternativas.adapter = AlternativeListAdapter(innerQuestion.alternatives, this)
        alternativas.layoutManager = LinearLayoutManager(this)

        var nextQuestion = proxima_questao
        if (showQuestionsIndex == 9) {
            nextQuestion.text = "Finish"
        }
    }

    private fun createQuestionsList(index: Int) {

        var question = Question("1 + " + index, "http://index.imgur.com/DvpvklR.png")

        var a1 = Alternative((0 + index).toString())
        var a2 = Alternative((1 + index).toString(), true)
        var a3 = Alternative((2 + index).toString())
        var a4 = Alternative((3 + index).toString())
        var a5 = Alternative((4 + index).toString())

        question.alternatives = listOf(a1, a2, a3, a4, a5)

        this.questions.add(question)
    }

}
