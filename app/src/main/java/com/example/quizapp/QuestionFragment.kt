package com.example.quizapp


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class QuestionFragment : Fragment() {

    lateinit var fragmentAction: FragmentAction

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
        return inflater.inflate(R.layout.fragment_question, container, false)
    }


    companion object {

        fun newInstance(bundle: Bundle? = null): QuestionFragment {
            var fragment = QuestionFragment()
            fragment.arguments = bundle
            return fragment
        }


    }


}
