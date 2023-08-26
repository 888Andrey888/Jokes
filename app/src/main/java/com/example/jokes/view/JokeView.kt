package com.example.jokes.view

import com.example.jokes.model.JokeAnswerModel
import com.example.jokes.model.JokeModel

interface JokeView {

    fun showJoke(setup: String, punchline: String)
    fun showError(message: String)

}