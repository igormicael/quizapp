package com.example.quizapp.model

data class Question(var text: String, var imgSrc: String) {
    lateinit var alternatives: List<Alternative>
}