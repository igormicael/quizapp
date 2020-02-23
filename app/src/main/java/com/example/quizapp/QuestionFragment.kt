package com.example.quizapp


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quizapp.action.FragmentAction
import com.example.quizapp.lists.AlternativaListAdapter
import com.example.quizapp.model.Alternativa
import com.example.quizapp.model.Question
import com.squareup.picasso.Picasso

class QuestionFragment : Fragment(), OnAlternativaListener {

    override fun onAlternativaClick(position: Int) {
        Log.v("teste", position.toString())

        var alternativas = questions[questionIndex].alternativas
        var alternativa = alternativas[position]

        if(alternativa.correct){
            correctAnswers ++
        }

        Log.v("TEste 1", alternativa.toString())

    }

    lateinit var fragmentAction: FragmentAction

    var questionIndex = 1

    var correctAnswers = 0

    var questions: ArrayList<Question> = arrayListOf()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            fragmentAction = context as FragmentAction
        } catch (e: Exception) {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_question, container, false)

        try {

            for (i in 0..9) {
                createQuestionsList(i)
            }

            if (this.questions.isNotEmpty()) {
                mostrarQuestao(view, 0)
            }

            var proxima_questao = view.findViewById<Button>(R.id.proxima_questao)
            proxima_questao.setOnClickListener {

                Log.v("Quantidade certa", correctAnswers.toString())

                var i = questionIndex++

                if (i <= 9) {
                    mostrarQuestao(view, i)
                }
            }

        } catch (e: java.lang.Exception) {
            Log.w(e.message, e.message)
            Log.w(e.message, e.printStackTrace().toString())
        }

        return view
    }

    private fun mostrarQuestao(view: View, indice: Int) {

        Log.v("QuestionFragment", indice.toString())

        var innerQuestion = questions[indice]

        val questionImage = view.findViewById<ImageView>(R.id.question_image)

        Picasso.get()
            .load(innerQuestion.imgSrc)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .into(questionImage)

        var enunciado = view.findViewById<TextView>(R.id.enunciado)

        enunciado.text = "Questão " + (indice + 1) + " : " + innerQuestion.text

        var alternativas =
            view.findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.alternativas)
        alternativas.adapter = AlternativaListAdapter(innerQuestion.alternativas, this)
        alternativas.layoutManager = LinearLayoutManager(context)

        var proxima_questao = view.findViewById<Button>(R.id.proxima_questao)
        if (indice == 9) {
            proxima_questao.text = "Finalizar"
        }
    }

    private fun createQuestionsList(i: Int) {

        var question = Question("1 + " + i, "http://i.imgur.com/DvpvklR.png")

        var a1 = Alternativa((0 + i).toString())
        var a2 = Alternativa((1 + i).toString(), true)
        var a3 = Alternativa((2 + i).toString())
        var a4 = Alternativa((3 + i).toString())
        var a5 = Alternativa((4 + i).toString())

        question.alternativas = listOf(a1, a2, a3, a4, a5)

        this.questions.add(question)
    }


    companion object {

        fun newInstance(bundle: Bundle? = null): QuestionFragment {
            var fragment = QuestionFragment()
            fragment.arguments = bundle
            return fragment
        }

    }
}
