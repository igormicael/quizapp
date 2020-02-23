package com.example.quizapp.model

import com.example.quizapp.model.Alternativa

data class Question (var text : String, var imgSrc: String){
    lateinit var alternativas: List<Alternativa>
}