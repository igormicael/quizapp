package com.example.quizapp.lists

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quizapp.OnAlternativaListener
import com.example.quizapp.R
import com.example.quizapp.model.Alternativa

class AlternativaListAdapter(var data: List<Alternativa>, onAlternativaListener: OnAlternativaListener) :
    RecyclerView.Adapter<AlternativaViewHolder>() {

    var escolhido = false

    var onAlternativaListener: OnAlternativaListener = onAlternativaListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlternativaViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.alternativa_list, parent, false)

        return AlternativaViewHolder(view, onAlternativaListener)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AlternativaViewHolder, position: Int) {
        val currentItem = data.get(position)

        holder.enuncionadoAlternativa.text = currentItem.text

        holder.enuncionadoAlternativa.setOnClickListener(){
            if(!escolhido){
                escolhido = true
                holder.onClick(it)
            }
        }
    }
}