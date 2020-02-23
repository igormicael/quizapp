package com.example.quizapp.action

import com.example.quizapp.model.Alternativa

interface QuestionAction {

    fun onClick(alternativa: Alternativa)
}