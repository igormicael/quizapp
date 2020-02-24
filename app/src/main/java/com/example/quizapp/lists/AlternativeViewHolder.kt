package com.example.quizapp.lists

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R

class AlternativeViewHolder(
    view: View,
    onAlternativeListener: OnAlternativeListener
) :
    RecyclerView.ViewHolder(view), View.OnClickListener {

    override fun onClick(v: View?) {

        if (v != null) {
            enuncionadoAlternativa.setBackgroundColor(v.resources.getColor(R.color.colorPrimaryDark))
        }

        onAlternativeListener.onAlternativaClick(adapterPosition)
    }

    var onAlternativeListener: OnAlternativeListener = onAlternativeListener

    var enuncionadoAlternativa: TextView

    init {
        enuncionadoAlternativa = view.findViewById(R.id.enunciado_alternativa)

        view.setOnClickListener(this)
    }
}