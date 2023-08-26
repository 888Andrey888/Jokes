package com.example.jokes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jokes.databinding.ActivityMainBinding
import com.example.jokes.model.JokeAnswerModel
import com.example.jokes.view.JokeView

class MainActivity : AppCompatActivity(), JokeView {

    private lateinit var binding: ActivityMainBinding
    private val presenter = Presenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        binding.btnJoke.setOnClickListener {
            presenter.getJokeResult()
        }
    }

    override fun showJoke(setup: String, punchline: String) {
        binding.tvSetup.text = setup
        binding.tvPunchline.text = punchline
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}