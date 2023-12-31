package com.example.jokes

import com.example.jokes.model.JokeModel
import com.example.jokes.model.RetrofitService
import com.example.jokes.view.JokeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Presenter(private val jokeView: JokeView) {

    private val api = RetrofitService().api

    fun getJokeResult() {
        api.getJoke().enqueue(object : Callback<JokeModel>{
            override fun onResponse(call: Call<JokeModel>, response: Response<JokeModel>) {
                response.body()?.let {
                    jokeView.showJoke(it.body.first().setup, it.body.first().punchline)
                }
            }

            override fun onFailure(call: Call<JokeModel>, t: Throwable) {
                jokeView.showError(t.message.toString())
            }

        })
    }
}