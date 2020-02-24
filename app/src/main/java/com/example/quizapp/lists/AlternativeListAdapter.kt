package com.example.quizapp.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.R
import com.example.quizapp.model.Alternative

class AlternativeListAdapter(
    var data: List<Alternative>,
    onAlternativeListener: OnAlternativeListener
) :
    RecyclerView.Adapter<AlternativeViewHolder>() {

    var escolhido = false

    var onAlternativeListener: OnAlternativeListener = onAlternativeListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlternativeViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.alternativa_list, parent, false)

        return AlternativeViewHolder(view, onAlternativeListener)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AlternativeViewHolder, position: Int) {
        val currentItem = data.get(position)

        holder.enuncionadoAlternativa.text = currentItem.text

        holder.enuncionadoAlternativa.setOnClickListener {
            if (!escolhido) {
                escolhido = true
                holder.onClick(it)
            }
        }
    }
}