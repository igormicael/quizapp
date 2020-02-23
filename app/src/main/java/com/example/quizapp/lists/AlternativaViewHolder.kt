package com.example.quizapp.lists

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.OnAlternativaListener
import com.example.quizapp.R

class AlternativaViewHolder(
    view: View,
    onAlternativaListener: OnAlternativaListener
) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    var escolhido = false

    override fun onClick(v: View?) {

        if(v != null){
            if(!escolhido){
                card.setBackgroundColor( v.resources.getColor(R.color.colorPrimaryDark) )
                enuncionadoAlternativa.setBackgroundColor( v.resources.getColor(R.color.colorPrimaryDark) )
                escolhido = true
            }
        }

        onAlternativaListener.onAlternativaClick(adapterPosition)
    }

    lateinit var onAlternativaListener: OnAlternativaListener;

    var enuncionadoAlternativa: TextView
    var card: CardView

    init {
        enuncionadoAlternativa = view.findViewById(R.id.enunciado_alternativa)
        card = view.findViewById(R.id.card)

        view.setOnClickListener(this)
        this.onAlternativaListener = onAlternativaListener

    }
}